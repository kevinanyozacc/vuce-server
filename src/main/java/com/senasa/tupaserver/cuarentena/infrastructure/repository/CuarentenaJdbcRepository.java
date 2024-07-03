package com.senasa.tupaserver.cuarentena.infrastructure.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaEntity;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaMapper;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaRepository;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaCreateDto;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc.CuarentenaDeleteJdbc;
import com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc.CuarentenaSaveJdbc;
import com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc.CuarentenaSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class CuarentenaJdbcRepository implements CuarentenaRepository {
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
  public CuarentenaEntity createCuarentena(CuarentenaCreateDto params) throws SQLException {
    String id = new CuarentenaSelectJdbc(this.jdbcTemplate).generateId();
    CuarentenaEntity payload = this.modelMapper.map(params, CuarentenaEntity.class);
    payload.setId(id);
    return new CuarentenaSaveJdbc(this.connection).execute(payload);
  }

  @Override
  public List<CuarentenaMapper> listCuarentenas(CuarentenaListDto params) {
    QueryBuilderSql queryBuilder = new CuarentenaSelectJdbc().query(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new CuarentenaMapper(row, index));
  }

  @Override
  public boolean deleteCuarentenas(CuarentenaListDto params) throws SQLException {
    return new CuarentenaDeleteJdbc(this.connection).execute(params);
  }
}
