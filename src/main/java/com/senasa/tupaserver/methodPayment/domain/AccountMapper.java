package com.senasa.tupaserver.methodPayment.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper extends AccountEntity {
  public AccountMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_CTA_CTE"));
    this.setBankId(rs.getString("CODIGO_BANCO"));
    this.setNumber(rs.getString("NUMERO_CTA"));
    this.setState(rs.getString("ESTADO"));
  }
}
