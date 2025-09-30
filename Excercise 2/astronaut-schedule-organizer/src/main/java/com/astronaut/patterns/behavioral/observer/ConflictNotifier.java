package com.astronaut.patterns.behavioral.observer;

import com.astronaut.models.Task;
import com.astronaut.utils.Logger;

public class ConflictNotifier implements TaskObserver {
  private final Logger logger;

  public ConflictNotifier() {
    this.logger = Logger.getInstance();
  }

  @Override
  public void onTaskConflict(Task newTask, Task conflictingTask) {
    String message =
        String.format(
            "CONFLICT DETECTED! Task '%s' (%s-%s) conflicts with '%s' (%s-%s)",
            newTask.getDescription(),
            newTask.getStartTime(),
            newTask.getEndTime(),
            conflictingTask.getDescription(),
            conflictingTask.getStartTime(),
            conflictingTask.getEndTime());
    logger.warn(message);
    System.out.println("\n⚠️ " + message + "\n");
  }

  @Override
  public void onTaskAdded(Task task) {
    logger.info("Task added: " + task.getDescription());
    System.out.println("✓ Task added successfully: " + task.getDescription());
  }

  @Override
  public void onTaskRemoved(Task task) {
    logger.info("Task removed: " + task.getDescription());
    System.out.println("✓ Task removed successfully: " + task.getDescription());
  }

  @Override
  public void onTaskUpdated(Task task) {
    logger.info("Task updated: " + task.getDescription());
    System.out.println("✓ Task updated successfully: " + task.getDescription());
  }
}
