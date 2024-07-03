package com.senasa.tupaserver.cuarentena.infrastructure.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaEntity;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class CuarentenaSaveJdbc {
  public CuarentenaSaveJdbc(Connection connection) {
    this.connection = connection;
  }

  Connection connection;

  public CuarentenaEntity execute(CuarentenaEntity params) throws SQLException {
    QueryBuilderSql queryBuilder = new QueryBuilderSql().from("FINALBPM.REGISTRO_CUARENTENA_PRODUCTO");
    // add require
    queryBuilder.addAttribute("CODIGO_CUARENTENA_PRODUCTO");
    queryBuilder.addAttribute("SECUENCIAL_PRODUCTO");
    queryBuilder.addAttribute("CODIGO_EXPEDIENTE");
    queryBuilder.addAttribute("CODIGO_PRODUCTO");
    queryBuilder.addAttribute("PESO_PRODUCTO");
    queryBuilder.addAttribute("SEXO_PRODUCTO");
    queryBuilder.addAttribute("EDAD_PRODUCTO");
    queryBuilder.addAttribute("CANTIDAD_PRODUCTO");
    queryBuilder.addAttribute("AUTORIZACION_PRODUCTO");
    queryBuilder.addAttribute("PAIS_ID");
    queryBuilder.addAttribute("TIPO_PRODUCTO");
    // query
    PreparedStatement prepared = this.connection.prepareStatement(queryBuilder.getInsert());
    prepared.setString(1, params.getId());
    prepared.setInt(2, params.getSecuencia());
    prepared.setString(3, params.getExpedienteId());
    prepared.setString(4, params.getProductId());
    prepared.setString(5, params.getWeight());
    prepared.setString(6, params.getGender());
    prepared.setInt(7, params.getAge());
    prepared.setDouble(8, params.getAmount());
    prepared.setString(9, params.getAuthorization());
    prepared.setString(10, params.getPaisId());
    prepared.setString(11, params.getType());
    // execute
    prepared.execute();
    // reponse
    return params;
  }
}
