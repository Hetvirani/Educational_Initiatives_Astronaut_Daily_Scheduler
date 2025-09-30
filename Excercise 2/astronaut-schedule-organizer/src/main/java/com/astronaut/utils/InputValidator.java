package com.astronaut.utils;

public class InputValidator {
  public static boolean isNullOrEmpty(String value) {
    return value == null || value.trim().isEmpty();
  }

  public static void validateDescription(String description) {
    if (isNullOrEmpty(description)) {
      throw new IllegalArgumentException("Description cannot be null or empty");
    }
    if (description.trim().length() > 200) {
      throw new IllegalArgumentException("Description cannot exceed 200 characters");
    }
  }

  public static void validateNotNull(Object obj, String fieldName) {
    if (obj == null) {
      throw new IllegalArgumentException(fieldName + " cannot be null");
    }
  }
}
