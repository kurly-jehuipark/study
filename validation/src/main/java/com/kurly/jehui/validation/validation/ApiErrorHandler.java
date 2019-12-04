package com.kurly.jehui.validation.validation;

import com.kurly.jehui.validation.validation.payload.Warning;
import com.kurly.jehui.validation.validation.payload.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class ApiErrorHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public String serverErrorHandler(BindException e) {
    demo(e);
    return "error";
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String serverErrorHandler(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    demo(bindingResult);
    return "error";
  }

  private void demo(BindingResult bindingResult) {
    List<FieldError> errors = bindingResult.getFieldErrors();

    for (FieldError error : errors) {
      ConstraintViolation<?> constraintViolation;
      if ((constraintViolation = fieldErrorUnwrap(error)) == null) {
        continue;
      }

      Set<Class<? extends Payload>> payloads =
          constraintViolation.getConstraintDescriptor().getPayload();

      if (payloads.contains(Error.class)) {
        log.error(constraintViolation.getMessage());
      } else if (payloads.contains(Warning.class)) {
        log.warn(constraintViolation.getMessage());
      } else {
        log.error("default, {}", constraintViolation.getMessage());
      }
    }
  }

  private ConstraintViolation<?> fieldErrorUnwrap(FieldError fieldError) {
    try {
      return fieldError.unwrap(ConstraintViolation.class);
    } catch (Exception e) {
      return null;
    }
  }
}