package com.astronaut.patterns.structural.decorator;

import com.astronaut.models.Task;

public class NotesDecorator extends TaskDecorator {
  private final String notes;

  public NotesDecorator(Task task, String notes) {
    super(task);
    this.notes = notes;
  }

  public String getNotes() {
    return notes;
  }

  @Override
  public String toString() {
    return decoratedTask.toString() + String.format(" [Notes: %s]", notes);
  }
}
