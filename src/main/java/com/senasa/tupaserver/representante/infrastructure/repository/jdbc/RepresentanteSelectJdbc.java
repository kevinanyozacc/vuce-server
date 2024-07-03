package com.senasa.tupaserver.representante.infrastructure.repository.jdbc;

import com.senasa.tupaserver.representante.domain.dtos.RepresentanteListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class RepresentanteSelectJdbc {
  public QueryBuilderSql query(RepresentanteListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql();
    queryBuilder.from("persona_representante_legal");
    // filters
    if (params.getPersonId() != null) {
      String condition = params.getPersonId();
      queryBuilder.andWhere("PERSONA_ID = '" + condition + "'");
    }
    // response
    return queryBuilder;
  }
}
