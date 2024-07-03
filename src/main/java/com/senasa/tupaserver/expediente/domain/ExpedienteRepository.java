package com.senasa.tupaserver.expediente.domain;

import java.sql.SQLException;
import java.sql.Connection;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;

public interface ExpedienteRepository {
  public void createConnection() throws SQLException;

  public Connection getConnection();

  public ExpedienteMapper findExpediente(ExpedienteFindDto params) throws SQLException;

  public ExpedienteSaveResponseDto saveExpediente(ExpedienteSaveDto params) throws SQLException, Exception;
}
