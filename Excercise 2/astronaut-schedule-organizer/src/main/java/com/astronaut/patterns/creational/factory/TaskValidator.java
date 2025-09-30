package com.astronaut.patterns.creational.factory;

import com.astronaut.exceptions.InvalidTimeException;
import com.astronaut.models.Priority;
import com.astronaut.utils.InputValidator;
import com.astronaut.utils.TimeValidator;
import java.time.LocalTime;

public class TaskValidator {
  public void validateTaskInput(String description, String startTimeStr, String endTimeStr, String priorityStr)
      throws InvalidTimeException {
    InputValidator.validateDescription(description);

    LocalTime startTime = TimeValidator.validateAndParseTime(startTimeStr);
    LocalTime endTime = TimeValidator.validateAndParseTime(endTimeStr);
    TimeValidator.validateTimeRange(startTime, endTime);

    Priority.fromString(priorityStr);
  }
}
