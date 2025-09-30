package com.astronaut.patterns.structural.adapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MilitaryTimeAdapter implements TimeFormatAdapter {
  private static final DateTimeFormatter MILITARY_FORMATTER = DateTimeFormatter.ofPattern("HHmm");

  @Override
  public LocalTime convertToLocalTime(String timeString) {
    if (timeString == null || timeString.trim().isEmpty()) {
      throw new IllegalArgumentException("Time string cannot be null or empty");
    }
    String cleaned = timeString.trim();
    if (cleaned.length() == 3) {
      cleaned = "0" + cleaned;
    }
    return LocalTime.parse(cleaned, MILITARY_FORMATTER);
  }

  @Override
  public String getFormatDescription() {
    return "Military Time (HHmm, e.g., 0900, 1430)";
  }
}
