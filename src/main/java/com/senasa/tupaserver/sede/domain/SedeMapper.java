package com.senasa.tupaserver.sede.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SedeMapper extends SedeEntity {
  public SedeMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_CENTRO_TRAMITE"));
    this.setName(rs.getString("DESCRIPCION_CENTRO_TRAMITE"));
  }
}
