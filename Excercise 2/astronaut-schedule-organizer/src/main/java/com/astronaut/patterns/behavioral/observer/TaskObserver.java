package com.astronaut.patterns.behavioral.observer;

import com.astronaut.models.Task;

public interface TaskObserver {
  void onTaskConflict(Task newTask, Task conflictingTask);
  void onTaskAdded(Task task);
  void onTaskRemoved(Task task);
  void onTaskUpdated(Task task);
}
