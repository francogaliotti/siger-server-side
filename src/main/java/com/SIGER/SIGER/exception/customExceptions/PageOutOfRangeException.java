package com.SIGER.SIGER.exception.customExceptions;

public class PageOutOfRangeException extends Exception {

  private static final long serialVersionUID = 1L;

  public PageOutOfRangeException(String message) {
    super(message);
  }
}
