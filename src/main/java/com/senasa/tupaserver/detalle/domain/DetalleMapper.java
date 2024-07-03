package com.senasa.tupaserver.detalle.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleMapper extends DetalleEntity {
  public DetalleMapper() {
  }

  public DetalleMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_CUARENTENA_DETALLE"));
    this.setExpedienteId(rs.getString("CODIGO_EXPEDIENTE"));
    this.setEstablishmentId(rs.getString("CODIGO_ESTABLECIMIENTO"));
    this.setTechnicalId(rs.getString("CODIGO_TECNICO_PERSONA"));
    this.setType(rs.getString("TIPO_DETALLE"));
    this.setNumberPSI(rs.getString("NUMERO_PSI"));
    this.setSourceCountryId(rs.getString("SOURCE_PAIS_ID"));
    this.setTargetCountryId(rs.getString("TARGET_PAIS_ID"));
    this.setPlace(rs.getString("TARGET_PAIS_ID"));
  }
}
