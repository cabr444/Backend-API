package org.cabr4.exceptions;

public class BadRequestException extends RuntimeException{
  public BadRequestException(String message) {
    super(message);
  }
}
