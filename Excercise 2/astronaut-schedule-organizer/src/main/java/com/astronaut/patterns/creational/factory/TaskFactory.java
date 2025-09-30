package com.astronaut.patterns.creational.factory;

import com.astronaut.exceptions.InvalidTimeException;
import com.astronaut.models.Priority;
import com.astronaut.models.Task;
import com.astronaut.utils.Logger;
import com.astronaut.utils.TimeValidator;
import java.time.LocalTime;

public class TaskFactory {
  private final TaskValidator validator;
  private final Logger logger;

  public TaskFactory() {
    this.validator = new TaskValidator();
    this.logger = Logger.getInstance();
  }

  public Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr)
      throws InvalidTimeException {
    logger.debug("Creating task: " + description);

    validator.validateTaskInput(description, startTimeStr, endTimeStr, priorityStr);

    LocalTime startTime = TimeValidator.validateAndParseTime(startTimeStr);
    LocalTime endTime = TimeValidator.validateAndParseTime(endTimeStr);
    Priority priority = Priority.fromString(priorityStr);

    Task task = new Task(description, startTime, endTime, priority);
    logger.debug("Task created successfully with ID: " + task.getId());
    return task;
  }
}
