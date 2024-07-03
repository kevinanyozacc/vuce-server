package com.senasa.tupaserver.detalle.infrastructure.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.detalle.domain.DetalleEntity;
import com.senasa.tupaserver.detalle.domain.DetalleMapper;
import com.senasa.tupaserver.detalle.domain.DetalleRepository;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleCreateDto;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindDto;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleListDto;
import com.senasa.tupaserver.detalle.infrastructure.repository.jdbc.DetalleSaveJdbc;
import com.senasa.tupaserver.detalle.infrastructure.repository.jdbc.DetalleSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DetalleJdbcRepository implements DetalleRepository {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  JdbcTemplate jdbcTemplate;

  Connection connection;

  @SuppressWarnings("null")
  @Override
  public void createConnection() throws SQLException {
    this.connection = this.jdbcTemplate.getDataSource().getConnection();
  }

  @Override
  public Connection getConnection() {
    return this.connection;
  }

  @Override
  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  @Override
  public DetalleMapper findDetalle(DetalleFindDto params) {
    QueryBuilderSql queryBuilder = new DetalleSelectJdbc().query(this.modelMapper.map(params, DetalleListDto.class));
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new DetalleMapper(row, index))
        .stream()
        .findFirst()
        .get();
  }

  @Override
  public DetalleEntity createDetalle(DetalleCreateDto params) throws SQLException {
    String id = new DetalleSelectJdbc(this.jdbcTemplate).generateId();
    DetalleEntity payload = this.modelMapper.map(params, DetalleEntity.class);
    payload.setId(id);
    return new DetalleSaveJdbc(this.connection).execute(payload);
  }
}
