package com.SIGER.SIGER.common;

public class PasswordValidation {

  public static boolean isValid(String password) {
    return password.length() >= 8;
  }

}
