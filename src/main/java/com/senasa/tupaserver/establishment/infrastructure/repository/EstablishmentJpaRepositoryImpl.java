package com.senasa.tupaserver.establishment.infrastructure.repository;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.establishment.domain.EstablishmentEntity;
import com.senasa.tupaserver.establishment.domain.EstablishmentMapper;
import com.senasa.tupaserver.establishment.domain.EstablishmentRepository;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentFindDto;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentListDto;
import com.senasa.tupaserver.establishment.infrastructure.repository.jdbc.EstablishmentSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class EstablishmentJpaRepositoryImpl implements EstablishmentRepository {

  @Autowired
  ModelMapper modelMapper;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  EstablishmentJpaRepository repository;

  @Override
  public EstablishmentEntity createEstablishment(EstablishmentEntity value) {
    String counter = new EstablishmentSelectJdbc(this.jdbcTemplate).generateId();
    value.setId(counter);
    return this.repository.save(value);
  }

  @Override
  public EstablishmentMapper findEstablishment(EstablishmentFindDto params) {
    EstablishmentListDto request = this.modelMapper.map(params, EstablishmentListDto.class);
    QueryBuilderSql queryBuilder = new EstablishmentSelectJdbc().query(request);
    List<EstablishmentMapper> result = this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new EstablishmentMapper(row, index));
    return result.stream().findFirst().get();
  }

  @Override
  public List<EstablishmentMapper> listEstablishments(EstablishmentListDto params) {
    EstablishmentListDto request = this.modelMapper.map(params, EstablishmentListDto.class);
    QueryBuilderSql queryBuilder = new EstablishmentSelectJdbc().query(request);
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new EstablishmentMapper(row, index));
  }
}
