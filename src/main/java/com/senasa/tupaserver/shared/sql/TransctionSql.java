package com.senasa.tupaserver.shared.sql;

import java.sql.SQLException;
import java.sql.Connection;

public interface TransctionSql {
  public void createConnection() throws SQLException;

  public Connection getConnection();

  public void setConnection(Connection connection);
}
