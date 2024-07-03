package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoMapper extends DepartamentoEntity {
  public DepartamentoMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODI_DEPA_DPT"));
    this.setName(rs.getString("NOMB_DPTO_DPT"));
  }
}
