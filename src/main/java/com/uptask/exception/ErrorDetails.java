package com.uptask.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
  private String timestamp;
  private String message;
  private String path;
  private String errorCode;
}
