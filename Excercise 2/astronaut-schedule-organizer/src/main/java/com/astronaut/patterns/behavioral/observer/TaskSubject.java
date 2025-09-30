package com.astronaut.patterns.behavioral.observer;

import com.astronaut.models.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskSubject {
  private final List<TaskObserver> observers;

  public TaskSubject() {
    this.observers = new ArrayList<>();
  }

  public void addObserver(TaskObserver observer) {
    if (observer != null && !observers.contains(observer)) {
      observers.add(observer);
    }
  }

  public void removeObserver(TaskObserver observer) {
    observers.remove(observer);
  }

  public void notifyConflict(Task newTask, Task conflictingTask) {
    for (TaskObserver observer : observers) {
      observer.onTaskConflict(newTask, conflictingTask);
    }
  }

  public void notifyTaskAdded(Task task) {
    for (TaskObserver observer : observers) {
      observer.onTaskAdded(task);
    }
  }

  public void notifyTaskRemoved(Task task) {
    for (TaskObserver observer : observers) {
      observer.onTaskRemoved(task);
    }
  }

  public void notifyTaskUpdated(Task task) {
    for (TaskObserver observer : observers) {
      observer.onTaskUpdated(task);
    }
  }
}
