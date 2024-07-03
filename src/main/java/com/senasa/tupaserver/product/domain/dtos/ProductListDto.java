package com.senasa.tupaserver.product.domain.dtos;

public class ProductListDto extends ProductFindDto {
  private String querySearch;

  public String getQuerySearch() {
    return this.querySearch;
  }

  public void setQuerySearch(String value) {
    this.querySearch = value;
  }
}
