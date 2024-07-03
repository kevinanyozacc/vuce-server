package com.senasa.tupaserver.shared.sql;

import java.util.List;

public class PaginateResponse<T> {
  public PaginateResponse(PaginateMeta meta, List<T> items) {
    this.meta = meta;
    this.items = items;
  }

  public PaginateMeta meta;
  public List<T> items;
}
