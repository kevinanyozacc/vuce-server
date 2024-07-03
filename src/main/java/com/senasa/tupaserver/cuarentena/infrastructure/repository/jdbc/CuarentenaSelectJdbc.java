package com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class CuarentenaSelectJdbc {
  public CuarentenaSelectJdbc() {
  }

  public CuarentenaSelectJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  JdbcTemplate jdbcTemplate;

  public String generateId() {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.REGISTRO_CUARENTENA_PRODUCTO")
        .select("NVL(MAX(CODIGO_CUARENTENA_PRODUCTO), 0) + 1 COUNTER");
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

  public QueryBuilderSql query(CuarentenaListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.REGISTRO_CUARENTENA_PRODUCTO CP")
        .innerJoin("FINALBPM.PRODUCTO PR", "PR.CODIGO_PRODUCTO = CP.CODIGO_PRODUCTO")
        .innerJoin("FINALBPM.PARTIDA_ARANCELARIA PA", "PA.CODIGO_PARTIDA_ARANCELARIA = PR.CODIGO_PARTIDA_ARANCELARIA")
        .leftJoin("SIGA.TPAISES TP", "TP.CODI_PAIS_TPA = CP.PAIS_ID")
        .select("CP.*")
        .addSelect("PR.CODIGO_CLASE", "CODIGO_CLASE")
        .addSelect("PR.NOMBRE_COMERCIAL_PRODUCTO", "NOMBRE_COMERCIAL_PRODUCTO")
        .addSelect("PR.NOMBRE_CIENTIFICO_PRODUCTO", "NOMBRE_CIENTIFICO_PRODUCTO")
        .addSelect("PR.ESTADO", "ESTADO_PRODUCTO")
        .addSelect("PR.CODIGO_PARTIDA_ARANCELARIA", "CODIGO_PARTIDA_ARANCELARIA")
        .addSelect("PA.DESCRIPCION_PART_ARANCELARIA", "DESCRIPCION_PART_ARANCELARIA")
        .addSelect("PA.PARTIDA_ARANCELARIA", "PARTIDA_ARANCELARIA")
        .addSelect("TP.CODI_PAIS_TPA", "CODIGO_PAIS")
        .addSelect("TP.NOMB_PAIS_TPA", "NOMB_PAIS_TPA");
    // filters
    if (params.getExpedienteId() != null) {
      String condition = "'" + params.getExpedienteId() + "'";
      queryBuilder.andWhere("CP.CODIGO_EXPEDIENTE LIKE " + condition);
    }
    // response
    return queryBuilder;
  }
}
