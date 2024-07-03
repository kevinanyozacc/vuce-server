package com.senasa.tupaserver.sede.infrastructure.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.sede.domain.SedeMapper;
import com.senasa.tupaserver.sede.domain.SedeRepository;
import com.senasa.tupaserver.sede.domain.dtos.SedeFindDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class SedeJpaRepository implements SedeRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<SedeMapper> listSedes() {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.CENTRO_TRAMITE");
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new SedeMapper(row, index));
  }

  @Override
  public SedeMapper findSede(SedeFindDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.CENTRO_TRAMITE");
    // filter
    if (params.getId() != null) {
      String condition = "'" + params.getId() + "'";
      queryBuilder.andWhere("CODIGO_CENTRO_TRAMITE = " + condition);
    }
    // response
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new SedeMapper(row, index))
        .stream()
        .findFirst()
        .get();
  }
}
