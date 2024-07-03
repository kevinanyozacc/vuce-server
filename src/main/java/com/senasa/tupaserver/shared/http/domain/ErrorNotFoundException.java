package com.senasa.tupaserver.shared.http.domain;

public class ErrorNotFoundException extends Exception {
  public ErrorNotFoundException(String message) {
    super(message);
  }

  private String statusCode = "NotFoundException";
  private int status = 404;

  public String getStatusCode() {
    return statusCode;
  }

  public int getStatus() {
    return status;
  }

  public boolean getSuccess() {
    return false;
  }
}
