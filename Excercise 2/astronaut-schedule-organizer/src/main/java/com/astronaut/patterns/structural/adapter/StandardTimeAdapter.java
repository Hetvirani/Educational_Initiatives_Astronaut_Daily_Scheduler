package com.astronaut.patterns.structural.adapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StandardTimeAdapter implements TimeFormatAdapter {
  private static final DateTimeFormatter STANDARD_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");

  @Override
  public LocalTime convertToLocalTime(String timeString) {
    if (timeString == null || timeString.trim().isEmpty()) {
      throw new IllegalArgumentException("Time string cannot be null or empty");
    }
    return LocalTime.parse(timeString.trim(), STANDARD_FORMATTER);
  }

  @Override
  public String getFormatDescription() {
    return "Standard Time (h:mm AM/PM, e.g., 9:00 AM, 2:30 PM)";
  }
}
