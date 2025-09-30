package com.astronaut.patterns.structural.adapter;

import java.time.LocalTime;

public interface TimeFormatAdapter {
  LocalTime convertToLocalTime(String timeString);
  String getFormatDescription();
}
