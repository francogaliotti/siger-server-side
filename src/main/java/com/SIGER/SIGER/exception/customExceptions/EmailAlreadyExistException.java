package com.SIGER.SIGER.exception.customExceptions;

public class EmailAlreadyExistException extends Exception {

  private final static String EMAIL_ALREADY_EXIST_MESSAGE = "Email already exist.";

  private static final long serialVersionUID = 1L;

  public EmailAlreadyExistException() {
    super(EMAIL_ALREADY_EXIST_MESSAGE);
  }

}
