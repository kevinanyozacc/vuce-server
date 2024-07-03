package com.senasa.tupaserver.area.infrastructure.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.area.domain.AreaMapper;
import com.senasa.tupaserver.area.domain.AreaRepository;
import com.senasa.tupaserver.area.domain.dtos.AreaFindDto;
import com.senasa.tupaserver.area.domain.dtos.AreaListDto;
import com.senasa.tupaserver.area.infrastructure.repository.jdbc.AreaSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class AreaJpaRepository implements AreaRepository {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<AreaMapper> listAreas(AreaListDto params) {
    QueryBuilderSql queryBuilder = new AreaSelectJdbc().query(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new AreaMapper(row, index));
  }

  @Override
  public AreaMapper findArea(AreaFindDto params) {
    AreaListDto request = this.modelMapper.map(params, AreaListDto.class);
    QueryBuilderSql queryBuilder = new AreaSelectJdbc().query(request);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new AreaMapper(row, index))
        .stream()
        .findFirst()
        .get();
  }
}
