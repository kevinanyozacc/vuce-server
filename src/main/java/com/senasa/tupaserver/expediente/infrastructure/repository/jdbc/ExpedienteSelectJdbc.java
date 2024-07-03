package com.senasa.tupaserver.expediente.infrastructure.repository.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import oracle.jdbc.OracleTypes;

public class ExpedienteSelectJdbc {
  public ExpedienteSelectJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  JdbcTemplate jdbcTemplate;

  @SuppressWarnings("null")
  public List<ExpedienteMapper> call(ExpedienteFindDto params) throws SQLException {
    String sql = "CALL FINALBPM.Pckg_Expediente.Sp_Obtener_Datos_Expediente(?,?)";
    Connection connection = this.jdbcTemplate.getDataSource().getConnection();
    List<ExpedienteMapper> data = new ArrayList<ExpedienteMapper>();
    try {
      CallableStatement cs = connection.prepareCall(sql);
      cs.setString(1, params.getId());
      cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
      System.out.println("EJECUTE -> " + sql);
      cs.execute();
      ResultSet result = (ResultSet) cs.getObject(2);
      while (result.next()) {
        data.add(new ExpedienteMapper(result, 0));
      }
      return data;
    } catch (Exception e) {
      throw e;
    } finally {
      connection.close();
    }
  }
}
