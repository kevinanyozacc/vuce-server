package com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class CuarentenaDeleteJdbc {
  public CuarentenaDeleteJdbc(Connection connection) {
    this.connection = connection;
  }

  Connection connection;

  public boolean execute(CuarentenaListDto params) throws SQLException {
    QueryBuilderSql queryBuilder = new QueryBuilderSql().from("FINALBPM.REGISTRO_CUARENTENA_PRODUCTO");
    // filters
    if (params.getExpedienteId() != null) {
      String condition = "'" + params.getExpedienteId() + "'";
      queryBuilder.andWhere("CODIGO_EXPEDIENTE = " + condition);
    }
    // query
    Statement prepared = this.connection.createStatement();
    return prepared.execute(queryBuilder.getDelete());
  }
}
