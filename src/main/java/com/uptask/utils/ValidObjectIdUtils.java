package com.uptask.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ObjectIdValidatorUtils.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidObjectIdUtils {
  /**
   * Default Message.
   * @return String with message.
   */
  String message() default "Invalid MongoDB ObjectId";

  /**
   * Groups.
   * @return Groups.
   */
  Class<?>[] groups() default {};

  /**
   * Payload.
   * @return Payload.
   */
  Class<? extends Payload>[] payload() default {};
}
