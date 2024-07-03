package com.senasa.tupaserver.methodPayment.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypePaymentMapper extends TypePaymentEntity {
  public TypePaymentMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_TIPO_PAGO"));
    this.setName(rs.getString("DESCRIPCION_TIPO_PAGO"));
    this.setState(rs.getString("ESTADO"));
  }
}
