package com.senasa.tupaserver.establishment.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.senasa.tupaserver.ubigeo.domain.UbigeoMapper;

public class EstablishmentMapper extends EstablishmentEntity {
  public EstablishmentMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("ID"));
    this.setType(rs.getString("TIPO"));
    this.setName(rs.getString("NOMBRE_ESTABLECIMIENTO"));
    this.setAddress(rs.getString("DIRECCION_ESTABLECIMIENTO"));
    this.setOwnerName(rs.getString("NOMBRE_PROPIETARIO"));
    this.setOwnerRuc(rs.getString("RUC_PROPIETARIO"));
    this.setDepartamentoId(rs.getString("DEPARTAMENTO_ID"));
    this.setProvinciaId(rs.getString("PROVINCIA_ID"));
    this.setDistritoId(rs.getString("DISTRITO_ID"));
    // validar ubigeo
    if (this.getDepartamentoId() != null) {
      this.ubigeo = new UbigeoMapper();
      this.ubigeo.setDepartamentoId(rs.getString("DEPARTAMENTO_ID"));
      this.ubigeo.setDepartamentoName(rs.getString("NOMB_DPTO_DPT"));
      this.ubigeo.setProvinciaId(rs.getString("PROVINCIA_ID"));
      this.ubigeo.setProvinciaName(rs.getString("NOMB_PROV_TPR"));
      this.ubigeo.setDistritoId(rs.getString("DISTRITO_ID"));
      this.ubigeo.setDistritoName(rs.getString("NOMB_DIST_TDI"));
      this.ubigeo.generateId();
    }
  }

  private UbigeoMapper ubigeo;

  public UbigeoMapper getUbigeo() {
    return this.ubigeo;
  }

  public void setUbigeo(UbigeoMapper value) {
    this.ubigeo = value;
  }
}
