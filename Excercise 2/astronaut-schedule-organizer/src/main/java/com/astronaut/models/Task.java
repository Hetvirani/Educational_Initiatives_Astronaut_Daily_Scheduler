package com.astronaut.models;

import java.time.LocalTime;
import java.util.UUID;

public class Task {
  private final String id;
  private String description;
  private LocalTime startTime;
  private LocalTime endTime;
  private Priority priority;
  private TaskStatus status;

  public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
    this.id = UUID.randomUUID().toString();
    this.description = description;
    this.startTime = startTime;
    this.endTime = endTime;
    this.priority = priority;
    this.status = TaskStatus.PENDING;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public boolean conflictsWith(Task other) {
    if (other == null) return false;
    return !(this.endTime.isBefore(other.startTime)
        || this.startTime.isAfter(other.endTime)
        || this.endTime.equals(other.startTime)
        || this.startTime.equals(other.endTime));
  }

  @Override
  public String toString() {
    return String.format(
        "%s - %s: %s [%s] (%s)",
        startTime.toString(), endTime.toString(), description, priority, status);
  }
}
