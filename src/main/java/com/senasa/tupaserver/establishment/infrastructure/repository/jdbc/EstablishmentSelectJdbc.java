package com.senasa.tupaserver.establishment.infrastructure.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class EstablishmentSelectJdbc {
  public EstablishmentSelectJdbc() {
  }

  public EstablishmentSelectJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  JdbcTemplate jdbcTemplate;

  public String generateId() {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.ESTABLECIMIENTO")
        .select("NVL(MAX(ID), 0) + 1 COUNTER");
    String counter = jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> row.getString("COUNTER"))
        .stream()
        .findFirst()
        .get();
    int currentLen = counter.length();
    int zeroLen = 8 - currentLen;
    // agregar zero
    String zeroString = "";
    for (int i = 0; i < zeroLen; i++) {
      zeroString += "0";
    }
    // response
    return zeroString + counter;
  }

  public QueryBuilderSql query(EstablishmentListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql();
    queryBuilder.from("FINALBPM.ESTABLECIMIENTO EST")
        .innerJoin("SIGA.Tdepartamentos DEP", "DEP.CODI_DEPA_DPT = EST.DEPARTAMENTO_ID")
        .innerJoin("Siga.Tprovincias PRO",
            "PRO.CODI_DEPA_DPT = EST.DEPARTAMENTO_ID AND PRO.CODI_PROV_TPR = EST.PROVINCIA_ID")
        .innerJoin("Siga.Tdistritos DIS",
            "DIS.CODI_DIST_TDI = EST.DISTRITO_ID AND DIS.CODI_PROV_TPR = EST.PROVINCIA_ID AND DIS.CODI_DEPA_DPT = EST.DEPARTAMENTO_ID")
        .select("EST.*")
        .addSelect("DEP.NOMB_DPTO_DPT", "NOMB_DPTO_DPT")
        .addSelect("PRO.NOMB_PROV_TPR", "NOMB_PROV_TPR")
        .addSelect("DIS.NOMB_DIST_TDI", "NOMB_DIST_TDI");
    // filters
    if (params.getId() != null) {
      String condition = params.getId();
      queryBuilder.andWhere("EST.ID = '" + condition + "'");
    }

    if (params.getName() != null) {
      String condition = "UPPER('%" + params.getName() + "%')";
      queryBuilder.andWhere("UPPER(EST.NOMBRE_ESTABLECIMIENTO) LIKE " + condition);
    }

    if (params.getOwnerName() != null) {
      String condition = "UPPER('%" + params.getOwnerName() + "%')";
      queryBuilder.andWhere("UPPER(EST.NOMBRE_PROPIETARIO) LIKE " + condition);
    }

    if (params.getOwnerRuc() != null) {
      String condition = "'" + params.getOwnerRuc() + "'";
      queryBuilder.andWhere("EST.RUC_PROPIETARIO LIKE " + condition);
    }
    // response
    return queryBuilder;
  }
}
