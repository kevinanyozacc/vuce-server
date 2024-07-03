package com.senasa.tupaserver.area.infrastructure.repository.jdbc;

import com.senasa.tupaserver.area.domain.dtos.AreaListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class AreaSelectJdbc {
  public QueryBuilderSql query(AreaListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.AREA_GESTION");
    // filters
    if (params.getId() != null) {
      String condition = "'" + params.getId() + "'";
      queryBuilder.andWhere("CODIGO_AREA_GESTION = " + condition);
    }
    if (params.getState() != null) {
      String condition = "'" + params.getState() + "'";
      queryBuilder.andWhere("ESTADO = " + condition);
    }
    // response
    return queryBuilder;
  }
}
