package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistritoMapper extends DistritoEntity {
  public DistritoMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODI_DIST_TDI"));
    this.setDepartamentoId(rs.getString("CODI_DEPA_DPT"));
    this.setProvinciaId(rs.getString("CODI_PROV_TPR"));
    this.setName(rs.getString("NOMB_DIST_TDI"));
  }
}
