package com.uptask.task.utils;

public enum TaskStatus {
  PENDING("pending"),
  ON_HOLD("onHold"),
  IN_PROGRESS("inProgress"),
  UNDER_REVIEW("underReview"),
  COMPLETED("completed"),
  ;

  TaskStatus(String key) {
  }
}
