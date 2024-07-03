package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinciaMapper extends ProvinciaEntity {
  public ProvinciaMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODI_PROV_TPR"));
    this.setDepartamentoId(rs.getString("CODI_DEPA_DPT"));
    this.setName(rs.getString("NOMB_PROV_TPR"));
  }
}
