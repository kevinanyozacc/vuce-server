package com.senasa.tupaserver.detalle.infrastructure.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class DetalleSelectJdbc {
  public DetalleSelectJdbc() {
  }

  public DetalleSelectJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  JdbcTemplate jdbcTemplate;

  public String generateId() {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.EXPEDIENTE_CUARENTENA_DETALLE")
        .select("NVL(MAX(CODIGO_CUARENTENA_DETALLE), 0) + 1 COUNTER");
    String counter = jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> row.getString("COUNTER"))
        .stream()
        .findFirst()
        .get();
    int currentLen = counter.length();
    int zeroLen = 10 - currentLen;
    // agregar zero
    String zeroString = "";
    for (int i = 0; i < zeroLen; i++) {
      zeroString += "0";
    }
    // response
    return zeroString + counter;
  }

  public QueryBuilderSql query(DetalleListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.EXPEDIENTE_CUARENTENA_DETALLE CD")
        .leftJoin("SIGA.TPAISES PS", "CD.SOURCE_PAIS_ID = PS.CODI_PAIS_TPA")
        .leftJoin("SIGA.TPAISES PT", "CD.TARGET_PAIS_ID = PT.CODI_PAIS_TPA");
    // filters
    if (params.getExpedienteId() != null) {
      String condition = "'" + params.getExpedienteId() + "'";
      queryBuilder.andWhere("CD.CODIGO_EXPEDIENTE = " + condition);
    }
    // response
    return queryBuilder;
  }
}
