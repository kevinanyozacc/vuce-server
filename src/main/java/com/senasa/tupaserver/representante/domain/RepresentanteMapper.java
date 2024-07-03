package com.senasa.tupaserver.representante.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepresentanteMapper extends RepresentanteEntity {
  public RepresentanteMapper() {
  }

  public RepresentanteMapper(@SuppressWarnings("null") ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("REPRESENTANTE_ID"));
    this.setPersonId(rs.getString("PERSONA_ID"));
    this.setFullname(rs.getString("NOMBRE_COMPLETO"));
    this.setCargo(rs.getString("CARGO"));
    this.setCargoDate(rs.getString("FECHA_CARGO"));
    this.setOrdenRepresentante(rs.getString("ORDEN_REPRESENTANTE"));
    this.setState(rs.getString("ESTADO"));
    this.setUserCreatedAt(rs.getString("USER_CREA"));
    this.setUserUpdatedAt(rs.getString("USER_MODI"));
    this.setCreatedAt(rs.getString("FECH_CREA"));
    this.setUpdatedAt(rs.getString("FECH_MODI"));
  }
}
