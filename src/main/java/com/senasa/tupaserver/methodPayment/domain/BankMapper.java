package com.senasa.tupaserver.methodPayment.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankMapper extends BankEntity {
  public BankMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_BANCO"));
    this.setName(rs.getString("NOMBRE_BANCO"));
    this.setState(rs.getString("ESTADO"));
  }
}
