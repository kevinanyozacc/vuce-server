package com.senasa.tupaserver.area.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaMapper extends AreaEntity {
  public AreaMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_AREA_GESTION"));
    this.setName(rs.getString("DESCRIPCION_AREA_GESTION"));
  }
}
