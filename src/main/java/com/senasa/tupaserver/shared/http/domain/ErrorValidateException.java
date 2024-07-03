package com.senasa.tupaserver.shared.http.domain;

public class ErrorValidateException extends Exception {
  public ErrorValidateException(ErrorFieldEntity errorField) {
    super(errorField.message);
    this.errorField = errorField;
  }

  private String statusCode = "NotFoundException";
  private ErrorFieldEntity errorField;
  private int status = 402;

  public String getStatusCode() {
    return statusCode;
  }

  public int getStatus() {
    return status;
  }

  public boolean getSuccess() {
    return false;
  }

  public ErrorFieldEntity getErrorField() {
    return this.errorField;
  }
}
