package org.cabr4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex){

    Map<String, Object> body = new HashMap<>();
    body.put("message", ex.getMessage());
    body.put("status", HttpStatus.NOT_FOUND.value());
    body.put("timestamp", LocalDateTime.now());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadRequestException.class)
  public  ResponseEntity<Object> handleBadRequest(BadRequestException ex){
    Map<String,Object> body = new HashMap<>();
    body.put("Message", ex.getMessage());
    body.put("status", HttpStatus.BAD_REQUEST.value());
    body.put("timestamp", LocalDateTime.now());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
