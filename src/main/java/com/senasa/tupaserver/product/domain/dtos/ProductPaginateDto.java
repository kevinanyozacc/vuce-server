package com.senasa.tupaserver.product.domain.dtos;

import javax.validation.constraints.NotBlank;

public class ProductPaginateDto extends ProductListDto {
  @NotBlank
  private int page;

  @NotBlank
  private int limit;

  public int getPage() {
    return this.page;
  }

  public void setPage(int value) {
    this.page = value;
  }

  public int getLimit() {
    return this.limit;
  }

  public void setLimit(int value) {
    this.limit = value;
  }
}
