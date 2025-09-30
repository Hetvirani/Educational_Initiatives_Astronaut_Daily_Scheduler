package com.astronaut.models;

public enum Priority {
  LOW("Low", 1),
  MEDIUM("Medium", 2),
  HIGH("High", 3),
  CRITICAL("Critical", 4);

  private final String displayName;
  private final int level;

  Priority(String displayName, int level) {
    this.displayName = displayName;
    this.level = level;
  }

  public String getDisplayName() {
    return displayName;
  }

  public int getLevel() {
    return level;
  }

  public static Priority fromString(String value) {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("Priority cannot be null or empty");
    }
    for (Priority priority : Priority.values()) {
      if (priority.name().equalsIgnoreCase(value.trim())) {
        return priority;
      }
    }
    throw new IllegalArgumentException("Invalid priority: " + value);
  }

  @Override
  public String toString() {
    return displayName;
  }
}
