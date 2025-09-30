package com.astronaut.services;

import com.astronaut.exceptions.InvalidTimeException;
import com.astronaut.exceptions.TaskConflictException;
import com.astronaut.exceptions.TaskNotFoundException;
import com.astronaut.models.Priority;
import com.astronaut.models.Task;
import com.astronaut.patterns.behavioral.strategy.PrioritySortStrategy;
import com.astronaut.patterns.behavioral.strategy.StartTimeSortStrategy;
import com.astronaut.patterns.creational.factory.TaskFactory;
import com.astronaut.patterns.creational.singleton.ScheduleManager;
import com.astronaut.patterns.structural.adapter.TimeFormatAdapter;
import com.astronaut.patterns.structural.decorator.NotesDecorator;
import com.astronaut.patterns.structural.decorator.ReminderDecorator;
import com.astronaut.utils.Logger;
import java.util.List;

public class TaskService {
  private final ScheduleManager scheduleManager;
  private final TaskFactory taskFactory;
  private final Logger logger;

  public TaskService() {
    this.scheduleManager = ScheduleManager.getInstance();
    this.taskFactory = new TaskFactory();
    this.logger = Logger.getInstance();
  }

  public void addTask(String description, String startTime, String endTime, String priority)
      throws InvalidTimeException, TaskConflictException {
    Task task = taskFactory.createTask(description, startTime, endTime, priority);
    scheduleManager.addTask(task);
  }

  public void addTaskWithAdapter(
      String description, String startTime, String endTime, String priority, TimeFormatAdapter adapter)
      throws InvalidTimeException, TaskConflictException {
    var startLocalTime = adapter.convertToLocalTime(startTime);
    var endLocalTime = adapter.convertToLocalTime(endTime);
    Task task = new Task(description, startLocalTime, endLocalTime, Priority.fromString(priority));
    scheduleManager.addTask(task);
  }

  public void removeTask(String description) throws TaskNotFoundException {
    scheduleManager.removeTask(description);
  }

  public void updateTask(String oldDescription, String newDescription, String startTime, String endTime, String priority)
      throws InvalidTimeException, TaskNotFoundException, TaskConflictException {
    Task updatedTask = taskFactory.createTask(newDescription, startTime, endTime, priority);
    scheduleManager.updateTask(oldDescription, updatedTask);
  }

  public void markTaskCompleted(String description) throws TaskNotFoundException {
    scheduleManager.markTaskCompleted(description);
  }

  public List<Task> viewAllTasks() {
    return scheduleManager.getAllTasks();
  }

  public List<Task> viewTasksByPriority(Priority priority) {
    return scheduleManager.getTasksByPriority(priority);
  }

  public void setSortByStartTime() {
    scheduleManager.setSortStrategy(new StartTimeSortStrategy());
    logger.info("Sort strategy set to: Start Time");
  }

  public void setSortByPriority() {
    scheduleManager.setSortStrategy(new PrioritySortStrategy());
    logger.info("Sort strategy set to: Priority");
  }

  public Task addTaskWithReminder(
      String description, String startTime, String endTime, String priority, int reminderMinutes)
      throws InvalidTimeException, TaskConflictException {
    Task task = taskFactory.createTask(description, startTime, endTime, priority);
    scheduleManager.addTask(task);
    return new ReminderDecorator(task, reminderMinutes);
  }

  public Task addTaskWithNotes(
      String description, String startTime, String endTime, String priority, String notes)
      throws InvalidTimeException, TaskConflictException {
    Task task = taskFactory.createTask(description, startTime, endTime, priority);
    scheduleManager.addTask(task);
    return new NotesDecorator(task, notes);
  }

  public int getTaskCount() {
    return scheduleManager.getTaskCount();
  }
}
