package com.senasa.tupaserver.shared.http.domain;

import java.util.ArrayList;
import java.util.List;

public class ErrorHttpEntity {
  public String message;
  public String statusCode;
  public boolean success;
  public int status;
  public List<ErrorFieldEntity> errors = new ArrayList<ErrorFieldEntity>();
}
