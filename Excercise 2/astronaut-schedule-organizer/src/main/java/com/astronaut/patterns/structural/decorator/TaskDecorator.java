package com.astronaut.patterns.structural.decorator;

import com.astronaut.models.Priority;
import com.astronaut.models.Task;
import com.astronaut.models.TaskStatus;
import java.time.LocalTime;

public abstract class TaskDecorator extends Task {
  protected Task decoratedTask;

  public TaskDecorator(Task task) {
    super(task.getDescription(), task.getStartTime(), task.getEndTime(), task.getPriority());
    this.decoratedTask = task;
  }

  @Override
  public abstract String toString();
}
