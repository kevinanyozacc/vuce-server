package com.senasa.tupaserver.procedure.infrastructure.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.procedure.domain.ProcedureInfoMapper;
import com.senasa.tupaserver.procedure.domain.ProcedureMapper;
import com.senasa.tupaserver.procedure.domain.ProcedureRepository;
import com.senasa.tupaserver.procedure.domain.ProcedureServiceMapper;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureInfoDto;
import com.senasa.tupaserver.procedure.infrastructure.repository.jdbc.ProcedureSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;
import oracle.jdbc.OracleTypes;

@Service
public class ProcedureJpaRepository implements ProcedureRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<ProcedureMapper> listProcedures(ProcedureFindDto params) {
    QueryBuilderSql queryBuilder = new ProcedureSelectJdbc().query(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new ProcedureMapper(row, index));
  }

  @SuppressWarnings("null")
  @Override
  public List<ProcedureInfoMapper> listInfoProcedures(ProcedureInfoDto params) throws SQLException {
    List<ProcedureInfoMapper> data = new ArrayList<ProcedureInfoMapper>();
    String sql = "CALL PCKG_GENERAL.Sp_Info_Procedimiento_Servicio(?, ?, ?)";
    Connection connection = this.jdbcTemplate.getDataSource().getConnection();
    // process
    try {
      CallableStatement cs = connection.prepareCall(sql);
      cs.setString(1, params.getProcedureId());
      cs.setString(2, params.getServiceId());
      cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
      System.out.println("EJECUTE -> " + sql);
      cs.execute();
      ResultSet result = (ResultSet) cs.getObject(3);
      while (result.next()) {
        ProcedureInfoMapper item = new ProcedureInfoMapper(result, 0);
        data.add(item);
      }
      return data;
    } catch (Exception e) {
      throw e;
    } finally {
      connection.close();
    }
  }

  @Override
  public List<ProcedureServiceMapper> listProcedureServices(ProcedureFindDto params) {
    QueryBuilderSql queryBuilder = new ProcedureSelectJdbc().queryService(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new ProcedureServiceMapper(row, index));
  }

  @SuppressWarnings("null")
  @Override
  public double calcProcedureTarifa(ProcedureCalcTarifaDto params) throws SQLException {
    String sql = "{?=call FINALBPM.Pckg_Tarifario.Fn_Calcular_Tasa_Servicio(?,?,?,?,?,?)}";
    Connection connection = this.jdbcTemplate.getDataSource().getConnection();
    try {
      CallableStatement cs = connection.prepareCall(sql);
      cs.registerOutParameter(1, OracleTypes.NUMBER);
      cs.setString(2, params.getServiceId());
      cs.setDouble(3, params.getAmount());
      cs.setString(4, "");
      cs.setString(5, "");
      cs.setString(6, "");
      cs.setString(7, "BPM");
      cs.execute();
      return cs.getDouble(1);
    } catch (Exception e) {
      throw e;
    } finally {
      connection.close();
    }
  }
}