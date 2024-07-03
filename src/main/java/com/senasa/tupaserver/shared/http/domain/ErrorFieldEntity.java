package com.senasa.tupaserver.shared.http.domain;

import org.springframework.validation.FieldError;

public class ErrorFieldEntity {
  public ErrorFieldEntity(FieldError error) {
    this.message = error.getDefaultMessage();
    this.field = error.getField();
  }

  public ErrorFieldEntity(String field, String message) {
    this.field = field;
    this.message = message;
  }

  public String field;
  public String message;
}
