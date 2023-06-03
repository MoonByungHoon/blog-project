package com.example.blog_project.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> runtimeException(final RuntimeException ex) {
    log.warn("Runtime error", ex);

    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity accessDeniedException(final AccessDeniedException ex) {
    log.warn("AccessDenied error", ex);

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> exception(final Exception ex) {
    log.info(ex.getClass().getName());
    log.error("error", ex);

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
