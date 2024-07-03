package com.senasa.tupaserver.ubigeo.domain.dtos;

import java.util.ArrayList;
import java.util.List;

public class PobladoListDto extends PobladoFindDto {
  private List<String> arrayId = new ArrayList<String>();

  public List<String> getArrayId() {
    return this.arrayId;
  }

  public void setArrayId(List<String> value) {
    this.arrayId = value;
  }
}
