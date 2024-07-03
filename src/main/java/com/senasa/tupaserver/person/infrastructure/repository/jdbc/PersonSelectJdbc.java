package com.senasa.tupaserver.person.infrastructure.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import com.senasa.tupaserver.person.domain.dtos.PersonListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class PersonSelectJdbc {
  public QueryBuilderSql query(PersonListDto request) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("PERSONA P")
        .innerJoin("FINALBPM.TIPO_DOCUMENTO TD", "TD.CODIGO_DOCUMENTO = P.DOCUMENTO_TIPO")
        .leftJoin("SIGA.Tdepartamentos DEP", "DEP.CODI_DEPA_DPT = P.DEPARTAMENTO_ID")
        .leftJoin("Siga.Tprovincias PRO",
            "PRO.CODI_DEPA_DPT = P.DEPARTAMENTO_ID AND PRO.CODI_PROV_TPR = P.PROVINCIA_ID")
        .leftJoin("Siga.Tdistritos DIS",
            "DIS.CODI_DIST_TDI = P.DISTRITO_ID AND DIS.CODI_PROV_TPR = P.PROVINCIA_ID AND DIS.CODI_DEPA_DPT = P.DEPARTAMENTO_ID")
        .select("P.*, TD.*")
        .addSelect("DEP.NOMB_DPTO_DPT", "NOMB_DPTO_DPT")
        .addSelect("PRO.NOMB_PROV_TPR", "NOMB_PROV_TPR")
        .addSelect("DIS.NOMB_DIST_TDI", "NOMB_DIST_TDI");
    // filters
    if (request.getId() != null) {
      String condition = request.getId();
      queryBuilder.andWhere("P.PERSONA_ID = '" + condition + "'");
    }
    if (request.getQuerySearch() != null) {
      String value = request.getQuerySearch();
      List<String> condition = new ArrayList<String>();
      condition.add("UPPER(P.NOMBRE_RAZON_SOCIAL) LIKE UPPER('%" + value + "%')");
      condition.add("UPPER(P.DOCUMENTO_NUMERO) LIKE UPPER('%" + value + "%')");
      queryBuilder.andWhere("(" + String.join(" OR ", condition) + ")");
    }
    if (request.getDocumentTypeId() != null) {
      String condition = request.getDocumentTypeId();
      queryBuilder.andWhere("P.DOCUMENTO_TIPO = '" + condition + "'");
    }
    if (request.getDocumentNumber() != null) {
      String condition = request.getDocumentNumber();
      queryBuilder.andWhere("P.DOCUMENTO_NUMERO = '" + condition + "'");
    }
    // response
    return queryBuilder;
  }
}
