package com.senasa.tupaserver.procedure.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureServiceMapper extends ProcedureServiceEntity {
  public ProcedureServiceMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_SERVICIO"));
    this.setName(rs.getString("DESCRIPCION_SERVICIO"));
    this.setTypeId(rs.getString("CODIGO_TIPO_SERVICIO"));
    this.setTypeName(rs.getString("DESCRIPCION_TIPO_SERVICIO"));
  }
}
