package com.uptask.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.bson.types.ObjectId;

public class ObjectIdValidatorUtils implements ConstraintValidator<ValidObjectIdUtils, String> {

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return ObjectId.isValid(s);
  }
}
