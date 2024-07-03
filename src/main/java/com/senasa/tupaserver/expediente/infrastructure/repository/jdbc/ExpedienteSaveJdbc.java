package com.senasa.tupaserver.expediente.infrastructure.repository.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSavePaymentDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveServiceDto;
import oracle.jdbc.OracleTypes;
import java.util.ArrayList;
import java.util.List;

public class ExpedienteSaveJdbc {
  public ExpedienteSaveJdbc(JdbcTemplate jdbcTemplate, Connection connection) throws SQLException {
    this.jdbcTemplate = jdbcTemplate;
    this.connection = connection;
  }

  JdbcTemplate jdbcTemplate;
  Connection connection;

  public ExpedienteSaveResponseDto call(ExpedienteSaveDto params) throws Exception {
    List<String> arrayService = new ArrayList<String>();
    List<String> arrayPayment = new ArrayList<String>();
    String sql = "CALL pckg_grabar.Sp_Grabar_Inactivo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    CallableStatement cs = connection.prepareCall(sql);
    cs.setString(1, params.getSedeId());
    cs.setString(2, "BPM");
    cs.setString(3, params.getPersonId());
    cs.setString(4, params.getOtherPersonId());
    cs.setString(5, params.getProcedureId());
    cs.setString(6, params.getUserId());
    cs.setString(7, params.getRequestPersonId());
    cs.setString(8, params.getRepresentanteId());
    cs.registerOutParameter(9, OracleTypes.VARCHAR);
    cs.setString(10, params.getId());
    cs.registerOutParameter(10, OracleTypes.VARCHAR);
    cs.registerOutParameter(11, OracleTypes.VARCHAR);
    cs.registerOutParameter(12, OracleTypes.VARCHAR);
    // agregar services
    params.getServices().forEach((item) -> arrayService.add(this.generateService(item)));
    cs.setString(13, String.join("<->", arrayService));
    cs.setString(14, null);
    // agregar payments
    params.getPayments().forEach((item) -> arrayPayment.add(this.generatePayment(item)));
    cs.setString(15, String.join("<->", arrayPayment));
    System.out.println("EJECUTE -> " + sql);
    cs.execute();
    // response
    ExpedienteSaveResponseDto result = new ExpedienteSaveResponseDto();
    result.setRequestId(cs.getString(9));
    result.setId(cs.getString(10));
    result.setPaymentId(cs.getString(11));
    result.setStdId(cs.getString(12));
    return result;
  }

  private String generateService(ExpedienteSaveServiceDto item) {
    List<String> data = new ArrayList<String>();
    data.add(item.getServiceId());
    data.add(String.valueOf(item.getAmount()));
    data.add(String.valueOf(item.getPrice()));
    return String.join("]]", data);
  }

  private String generatePayment(ExpedienteSavePaymentDto item) {
    List<String> data = new ArrayList<String>();
    data.add(item.getTypeId());
    data.add(String.valueOf(item.getAmount()));
    data.add(item.getAccountId());
    data.add(item.getDate());
    data.add(item.getNumber());
    return String.join("]]", data);
  }

  public Connection getConnection() {
    return this.connection;
  }

  public void setConnection(Connection value) {
    this.connection = value;
  }
}
