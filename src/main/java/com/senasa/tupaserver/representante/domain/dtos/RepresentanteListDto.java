package com.senasa.tupaserver.representante.domain.dtos;

import javax.validation.constraints.NotBlank;

public class RepresentanteListDto extends RepresentanteFindDto {
  @NotBlank
  private String querySearch;

  @NotBlank
  private String personId;

  public String getQuerySearch() {
    return this.querySearch;
  }

  public void setQuerySearch(String value) {
    this.querySearch = value;
  }

  public String getPersonId() {
    return this.personId;
  }

  public void setPersonId(String value) {
    this.personId = value;
  }
}
