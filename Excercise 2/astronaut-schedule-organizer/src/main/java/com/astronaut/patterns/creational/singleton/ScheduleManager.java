package com.astronaut.patterns.creational.singleton;

import com.astronaut.exceptions.TaskConflictException;
import com.astronaut.exceptions.TaskNotFoundException;
import com.astronaut.models.Priority;
import com.astronaut.models.Task;
import com.astronaut.models.TaskStatus;
import com.astronaut.patterns.behavioral.observer.TaskSubject;
import com.astronaut.patterns.behavioral.strategy.SortStrategy;
import com.astronaut.patterns.behavioral.strategy.StartTimeSortStrategy;
import com.astronaut.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScheduleManager {
  private static ScheduleManager instance;

  private final List<Task> tasks;
  private final TaskSubject taskSubject;
  private final Logger logger;
  private SortStrategy sortStrategy;

  private ScheduleManager() {
    this.tasks = new ArrayList<>();
    this.taskSubject = new TaskSubject();
    this.logger = Logger.getInstance();
    this.sortStrategy = new StartTimeSortStrategy();
    logger.info("ScheduleManager initialized");
  }

  public static ScheduleManager getInstance() {
    if (instance == null) {
      synchronized (ScheduleManager.class) {
        if (instance == null) {
          instance = new ScheduleManager();
        }
      }
    }
    return instance;
  }

  public void setSortStrategy(SortStrategy strategy) {
    this.sortStrategy = strategy;
    logger.debug("Sort strategy changed to: " + strategy.getStrategyName());
  }

  public void addTask(Task task) throws TaskConflictException {
    if (task == null) {
      throw new IllegalArgumentException("Task cannot be null");
    }
    Optional<Task> conflictingTask = findConflictingTask(task);
    if (conflictingTask.isPresent()) {
      taskSubject.notifyConflict(task, conflictingTask.get());
      throw new TaskConflictException("Task conflicts with existing task: " + conflictingTask.get().getDescription());
    }
    tasks.add(task);
    taskSubject.notifyTaskAdded(task);
    logger.info("Task added: " + task.getDescription());
  }

  public void removeTask(String description) throws TaskNotFoundException {
    Optional<Task> taskToRemove = findTaskByDescription(description);
    if (taskToRemove.isEmpty()) {
      throw new TaskNotFoundException("Task not found: " + description);
    }
    tasks.remove(taskToRemove.get());
    taskSubject.notifyTaskRemoved(taskToRemove.get());
    logger.info("Task removed: " + description);
  }

  public void updateTask(String description, Task updatedTask)
      throws TaskNotFoundException, TaskConflictException {
    Optional<Task> existingTask = findTaskByDescription(description);
    if (existingTask.isEmpty()) {
      throw new TaskNotFoundException("Task not found: " + description);
    }

    Task original = existingTask.get();
    for (Task task : tasks) {
      if (!task.getId().equals(original.getId()) && task.conflictsWith(updatedTask)) {
        throw new TaskConflictException("Updated task conflicts with: " + task.getDescription());
      }
    }

    original.setDescription(updatedTask.getDescription());
    original.setStartTime(updatedTask.getStartTime());
    original.setEndTime(updatedTask.getEndTime());
    original.setPriority(updatedTask.getPriority());

    taskSubject.notifyTaskUpdated(original);
    logger.info("Task updated: " + description);
  }

  public void markTaskCompleted(String description) throws TaskNotFoundException {
    Optional<Task> task = findTaskByDescription(description);
    if (task.isEmpty()) {
      throw new TaskNotFoundException("Task not found: " + description);
    }
    task.get().setStatus(TaskStatus.COMPLETED);
    taskSubject.notifyTaskUpdated(task.get());
    logger.info("Task marked as completed: " + description);
  }

  public List<Task> getAllTasks() {
    return sortStrategy.sort(new ArrayList<>(tasks));
  }

  public List<Task> getTasksByPriority(Priority priority) {
    return tasks.stream()
        .filter(task -> task.getPriority() == priority)
        .collect(Collectors.toList());
  }

  public void addObserver(com.astronaut.patterns.behavioral.observer.TaskObserver observer) {
    taskSubject.addObserver(observer);
  }

  private Optional<Task> findConflictingTask(Task newTask) {
    return tasks.stream().filter(existing -> existing.conflictsWith(newTask)).findFirst();
  }

  private Optional<Task> findTaskByDescription(String description) {
    return tasks.stream().filter(task -> task.getDescription().equalsIgnoreCase(description.trim())).findFirst();
  }

  public int getTaskCount() {
    return tasks.size();
  }
}
