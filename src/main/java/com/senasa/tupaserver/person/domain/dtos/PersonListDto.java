package com.senasa.tupaserver.person.domain.dtos;

public class PersonListDto extends PersonFindDto {
  private String querySearch;

  public String getQuerySearch() {
    return this.querySearch;
  }

  public void setQuerySearch(String value) {
    this.querySearch = value;
  }

  @Override
  public String toString() {
    return "querySearch=" + this.getQuerySearch();
  }
}
