package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PobladoMapper extends PobladoEntity {
  public PobladoMapper(ResultSet rs, int index) throws SQLException {
    this.setDepartamentoId(rs.getString("CODI_DEPA_DPT"));
    this.setProvinciaId(rs.getString("CODI_PROV_TPR"));
    this.setDistritoId(rs.getString("CODI_DIST_TDI"));
    this.setCentroId(rs.getString("CODI_CCPP_TCP"));
    this.setName(rs.getString("NOMB_CCPP_TCP"));
  }
}
