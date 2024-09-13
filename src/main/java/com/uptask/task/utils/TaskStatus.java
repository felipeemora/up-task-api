package com.uptask.task.utils;

public enum TaskStatus {
  PENDING("pending"),
  ON_HOLD("onHold"),
  IN_PROGRESS("inProgress"),
  UNDER_REVIEW("underReview"),
  COMPLETED("completed");

  private final String key;

  TaskStatus(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public static TaskStatus fromKey(String key) {
    for (TaskStatus status : TaskStatus.values()) {
      if (status.getKey().equalsIgnoreCase(key)) {
        return status;
      }
    }
    throw new IllegalArgumentException("Unknown status: " + key);
  }
}