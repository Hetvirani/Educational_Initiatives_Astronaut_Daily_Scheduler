package com.astronaut.utils;

import com.astronaut.exceptions.InvalidTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeValidator {
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

  public static LocalTime validateAndParseTime(String timeStr) throws InvalidTimeException {
    if (timeStr == null || timeStr.trim().isEmpty()) {
      throw new InvalidTimeException("Time cannot be null or empty");
    }
    try {
      LocalTime time = LocalTime.parse(timeStr.trim(), TIME_FORMATTER);
      return time;
    } catch (DateTimeParseException e) {
      throw new InvalidTimeException(
          "Invalid time format: " + timeStr + ". Expected format: HH:mm (e.g., 09:00)");
    }
  }

  public static void validateTimeRange(LocalTime startTime, LocalTime endTime) throws InvalidTimeException {
    if (startTime == null || endTime == null) {
      throw new InvalidTimeException("Start time and end time cannot be null");
    }
    if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
      throw new InvalidTimeException("Start time must be before end time");
    }
  }
}
