package com.senasa.tupaserver.shared.sql;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilderSql {
  private List<String> arrayFrom = new ArrayList<String>();
  private List<String> arraySelect = new ArrayList<String>();
  private List<String> arrayWhere = new ArrayList<String>();
  private List<String> arrayJoin = new ArrayList<String>();
  private List<String> arrayOrder = new ArrayList<String>();
  private List<String> arrayAttr = new ArrayList<String>();
  private List<String> arrayValue = new ArrayList<String>();

  public QueryBuilderSql() {
    this.arraySelect.add("*");
  }

  public QueryBuilderSql from(String table) {
    arrayFrom.clear();
    arrayFrom.add(table);
    return this;
  }

  public QueryBuilderSql select(String select) {
    this.arraySelect.clear();
    this.arraySelect.add(select);
    return this;
  }

  public QueryBuilderSql addSelect(String column, String alias) {
    this.arraySelect.add(column + " " + alias);
    return this;
  }

  public QueryBuilderSql andWhere(String condition) {
    if (arrayWhere.size() > 0) {
      arrayWhere.add(" AND " + condition);
    } else {
      arrayWhere.add(condition);
    }
    return this;
  }

  public QueryBuilderSql innerJoin(String table, String condition) {
    this.arrayJoin.add("INNER JOIN " + table + " ON " + condition);
    return this;
  }

  public QueryBuilderSql leftJoin(String table, String condition) {
    this.arrayJoin.add("LEFT JOIN " + table + " ON " + condition);
    return this;
  }

  public QueryBuilderSql orderBy(String column, String type) {
    this.arrayOrder.clear();
    this.arrayOrder.add(column + " " + type);
    return this;
  }

  public QueryBuilderSql addAttribute(String column) {
    this.arrayAttr.add(column);
    this.arrayValue.add("?");
    return this;
  }

  public String getSql() {
    // add select
    String selectString = String.join(", ", this.arraySelect);
    // add from
    String fromString = String.join(", ", this.arrayFrom);
    // add join
    String joinString = String.join(" ", this.arrayJoin);
    // add where
    String whereString = String.join(" ", this.arrayWhere);
    // add order
    String orderString = String.join(", ", this.arrayOrder);
    // builder
    String sqlRaw = "SELECT " + selectString;
    sqlRaw += " FROM " + fromString + "\n";
    // builder join
    if (!joinString.equals("")) {
      sqlRaw += joinString;
    }
    // builder where
    if (!whereString.equals("")) {
      sqlRaw += " WHERE " + whereString + "\n";
    }
    // builder order
    if (!orderString.equals("")) {
      sqlRaw += " ORDER BY " + orderString;
    }
    // response sql
    System.out.println(sqlRaw);
    return sqlRaw;
  }

  public String getInsert() {
    String attString = String.join(", ", this.arrayAttr);
    String valueString = String.join(", ", this.arrayValue);
    // builder
    String sqlRaw = "INSERT INTO " + this.arrayFrom.get(0) + "(" + attString + ")\n";
    sqlRaw += "VALUES(" + valueString + ")";
    // response
    System.out.println(sqlRaw);
    return sqlRaw;
  }

  public String getDelete() {
    String whereString = String.join("\n", this.arrayWhere);
    // builder
    String sqlRaw = "DELETE FROM " + this.arrayFrom.get(0) + "\n";
    sqlRaw += "WHERE " + whereString;
    // response
    System.out.println(sqlRaw);
    return sqlRaw;
  }
}
