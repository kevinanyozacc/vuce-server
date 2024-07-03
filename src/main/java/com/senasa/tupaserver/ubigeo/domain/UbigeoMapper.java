package com.senasa.tupaserver.ubigeo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UbigeoMapper extends UbigeoEntity {
  public UbigeoMapper() {
  }

  public UbigeoMapper(ResultSet rs, int index) throws SQLException {
    this.setDepartamentoId(rs.getString("CODI_DEPA_DPT"));
    this.setProvinciaId(rs.getString("CODI_PROV_TPR"));
    this.setDistritoId(rs.getString("CODI_DIST_TDI"));
    this.setDepartamentoName(rs.getString("NOMB_DPTO_DPT"));
    this.setProvinciaName(rs.getString("NOMB_PROV_TPR"));
    this.setDistritoName(rs.getString("NOMB_PROV_TPR"));
    this.generateId();
  }

  public void generateId() {
    this.id = this.getDepartamentoId() + this.getProvinciaId() + this.getDistritoId();
  }
}
