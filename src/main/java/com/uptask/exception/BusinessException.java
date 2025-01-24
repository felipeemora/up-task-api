package com.uptask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class BusinessException extends RuntimeException {

  public BusinessException() {
    super("Not authorized to perform this action");
  }
}
