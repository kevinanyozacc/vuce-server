package com.senasa.tupaserver.product.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeciesMapper extends SpeciesEntity {
  public SpeciesMapper() {
  }

  public SpeciesMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_ESPECIE"));
    this.setName(rs.getString("NOMB_SINO_SIN"));
  }
}
