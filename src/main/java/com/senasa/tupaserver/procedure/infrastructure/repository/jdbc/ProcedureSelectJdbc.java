package com.senasa.tupaserver.procedure.infrastructure.repository.jdbc;

import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class ProcedureSelectJdbc {
  public QueryBuilderSql query(ProcedureFindDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.PROCEDIMIENTO_TUPA PT");
    // filters
    if (params.getAreaId() != null) {
      String condition = "'" + params.getAreaId() + "'";
      queryBuilder.andWhere("PT.CODIGO_AREA_GESTION = " + condition);
    }
    // respones
    return queryBuilder;
  }

  public QueryBuilderSql queryService(ProcedureFindDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.PROCEDIMIENTO_TUPA PT")
        .innerJoin("FINALBPM.SERVICIO_TUPA_PROCEDIMIENTO TP",
            "PT.CODIGO_PROCEDIMIENTO_TUPA = TP.CODIGO_PROCEDIMIENTO_TUPA")
        .innerJoin("FINALBPM.SERVICIO_TUPA ST", "ST.CODIGO_SERVICIO = TP.CODIGO_SERVICIO_TUPA")
        .innerJoin("FINALBPM.TIPO_SERVICIO TS", "TS.CODIGO_TIPO_SERVICIO = ST.CODIGO_TIPO_SERVICIO")
        .select("ST.*")
        .addSelect("TS.DESCRIPCION_TIPO_SERVICIO", "DESCRIPCION_TIPO_SERVICIO");
    // filters
    if (params.getId() != null) {
      String condition = "'" + params.getId() + "'";
      queryBuilder.andWhere("PT.CODIGO_PROCEDIMIENTO_TUPA = " + condition);
    }
    // respones
    return queryBuilder;
  }
}