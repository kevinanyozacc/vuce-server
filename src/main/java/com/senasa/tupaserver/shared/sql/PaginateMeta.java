package com.senasa.tupaserver.shared.sql;

import org.springframework.data.domain.PageRequest;

public class PaginateMeta {
  public PaginateMeta() {
  }

  public PaginateMeta(PageRequest pageRequest, int itemCount, int total) {
    this.currentPage = pageRequest.getPageNumber();
    this.itemsPerPage = pageRequest.getPageSize();
    this.itemCount = itemCount;
    this.totalItems = total;
    this.totalPages = (int) Math.ceil(total / pageRequest.getPageSize());
  }

  public int currentPage;
  public int itemsPerPage;
  public int totalPages;
  public int totalItems;
  public int itemCount;
}
