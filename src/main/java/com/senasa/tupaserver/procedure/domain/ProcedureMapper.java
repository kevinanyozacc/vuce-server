package com.senasa.tupaserver.procedure.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureMapper extends ProcedureEntity {
  public ProcedureMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"));
    this.setName(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"));
    this.setIndicador(rs.getString("Indicador_Procedimiento_Espe"));
    this.setState(rs.getString("ESTADO"));
  }
}
