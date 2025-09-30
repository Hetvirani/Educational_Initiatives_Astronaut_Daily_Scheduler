package com.astronaut.patterns.structural.decorator;

import com.astronaut.models.Task;
import java.time.LocalTime;

public class ReminderDecorator extends TaskDecorator {
  private final int minutesBefore;

  public ReminderDecorator(Task task, int minutesBefore) {
    super(task);
    this.minutesBefore = minutesBefore;
  }

  public LocalTime getReminderTime() {
    return decoratedTask.getStartTime().minusMinutes(minutesBefore);
  }

  @Override
  public String toString() {
    return decoratedTask.toString()
        + String.format(" [Reminder: %d min before at %s]", minutesBefore, getReminderTime());
  }
}
