package com.senasa.tupaserver.shared.sql;

import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

public class PaginateSql<T> {
  private JdbcTemplate jdbcTemplate;
  private QueryBuilderSql clienBuilder;
  private int total = 0;
  private String sqlData;

  public PaginateSql(JdbcTemplate jdbcTemplate, QueryBuilderSql clienBuilder) {
    this.jdbcTemplate = jdbcTemplate;
    this.clienBuilder = clienBuilder;
  }

  public PaginateSql<T> execute(Pageable page)
      throws Exception {
    if (page.getPageNumber() <= 0) {
      throw new Exception("El numero de pagina debe ser mayor a cero");
    }
    // validar counter
    int counter = this.getTotalItems();
    // validar counter
    if (counter == 0) {
      return this;
    }
    // setting paginate
    int start = (int) (page.getPageNumber() - 1) * page.getPageSize();
    int end = Math.min((start + page.getPageSize()), counter);
    // data
    this.sqlData = this.getDataItems(start, end);
    return this;
  }

  private int getTotalItems() {
    CounterSql counter = new CounterSql(0);
    QueryBuilderSql queryBuilder = new QueryBuilderSql();
    queryBuilder.from("( " + this.clienBuilder.getSql() + " ) up")
        .select("COUNT(*) as total");
    this.jdbcTemplate.query(queryBuilder.getSql(),
        (rs, rowNum) -> new CounterSql(rs.getInt("total")))
        .forEach(item -> counter.setCounter(item.getCounter()));
    this.total = counter.getCounter();
    return counter.getCounter();
  }

  private String getDataItems(int start, int end) {
    // query tmp
    QueryBuilderSql queryTmp = new QueryBuilderSql();
    queryTmp.from("( " + this.clienBuilder.getSql() + " ) tmp")
        .select("rownum rn, tmp.*");
    // query container
    QueryBuilderSql queryBuilder = new QueryBuilderSql();
    queryBuilder.from("(" + queryTmp.getSql() + ") up")
        .andWhere("up.rn BETWEEN " + start + " AND " + end);
    // response sql
    return queryBuilder.getSql();
  }

  public int getTotal() {
    return this.total;
  }

  public String getSqlData() {
    return this.sqlData;
  }
}
