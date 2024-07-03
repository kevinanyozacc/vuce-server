package com.senasa.tupaserver.expediente.infrastructure.repository;

import java.sql.SQLException;
import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import com.senasa.tupaserver.expediente.infrastructure.repository.jdbc.ExpedienteSaveJdbc;
import com.senasa.tupaserver.expediente.infrastructure.repository.jdbc.ExpedienteSelectJdbc;

@Service
public class ExpedienteJdbcRepository implements ExpedienteRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;
  Connection connection;

  @SuppressWarnings("null")
  @Override
  public void createConnection() throws SQLException {
    this.connection = (Connection) this.jdbcTemplate.getDataSource().getConnection();
  }

  @Override
  public Connection getConnection() {
    return this.connection;
  }

  @Override
  public ExpedienteMapper findExpediente(ExpedienteFindDto params) throws SQLException {
    try {
      ExpedienteSelectJdbc queryBuilder = new ExpedienteSelectJdbc(this.jdbcTemplate);
      return queryBuilder.call(params).stream().findFirst().get();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public ExpedienteSaveResponseDto saveExpediente(ExpedienteSaveDto params) throws SQLException, Exception {
    ExpedienteSaveJdbc queryBuilder = new ExpedienteSaveJdbc(this.jdbcTemplate, this.connection);
    return queryBuilder.call(params);
  }
}
