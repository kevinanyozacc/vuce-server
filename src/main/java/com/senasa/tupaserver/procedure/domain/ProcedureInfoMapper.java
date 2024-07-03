package com.senasa.tupaserver.procedure.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureInfoMapper extends ProcedureInfoEntity {
  public ProcedureInfoMapper(ResultSet rs, int index) throws SQLException {
    this.setAreaId(rs.getString("Codigo_Area_Gestion"));
    this.setAreaName(rs.getString("Descripcion_Area_Gestion"));
    this.setProcedureId(rs.getString("Codigo_Procedimiento_Tupa"));
    this.setProcedureName(rs.getString("Descripcion_Procedimieto_Tupa"));
    this.setServiceId(rs.getString("Codigo_Servicio"));
    this.setServiceName(rs.getString("Descripcion_Servicio"));
  }
}
