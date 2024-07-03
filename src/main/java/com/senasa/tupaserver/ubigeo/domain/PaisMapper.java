package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisMapper extends PaisEntity {
  public PaisMapper() {
  }

  public PaisMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODI_PAIS_TPA"));
    this.setName(rs.getString("NOMB_PAIS_TPA"));
  }
}
