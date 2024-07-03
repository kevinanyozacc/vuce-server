package com.senasa.tupaserver.expediente.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpedienteMapper extends ExpedienteEntity {
  public ExpedienteMapper() {
  }

  public ExpedienteMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_EXPEDIENTE"));
    this.setDate(rs.getString("FECHA_REGISTRO"));
    this.setPersonId(rs.getString("PERSONA_ID"));
    this.setPersonName(rs.getString("NOMBRE_RAZON_SOCIAL"));
    this.setStdCodId(rs.getString("CODIGO_STD_DOC"));
    this.setServiceId(rs.getString("CODIGO_SERVICIO"));
    this.setServiceName(rs.getString("DESCRIPCION_SERVICIO"));
    this.setProcedureId(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"));
    this.setProcedureName(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"));
    this.setAreaName(rs.getString("DESCRIPCION_AREA_GESTION"));
    this.setSedeId(rs.getString("CODIGO_CENTRO_TRAMITE"));
    this.setSedeName(rs.getString("DESCRIPCION_CENTRO_TRAMITE"));
    this.setRequestId(rs.getString("CODIGO_SOLICITUD"));
    this.setNumberRegArc(rs.getString("NUME_REGI_ARC"));
    this.setUcmId(rs.getString("UCM_ID"));
    this.setOrdenVuce(rs.getString("ORDEN_VUCE"));
    this.setChannel(rs.getString("CANAL"));
  }
}
