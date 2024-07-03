package com.senasa.tupaserver.detalle.infrastructure.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.senasa.tupaserver.detalle.domain.DetalleEntity;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class DetalleSaveJdbc {
  public DetalleSaveJdbc(Connection connection) {
    this.connection = connection;
  }

  Connection connection;

  public DetalleEntity execute(DetalleEntity params) throws SQLException {
    QueryBuilderSql queryBuilder = new QueryBuilderSql().from("FINALBPM.EXPEDIENTE_CUARENTENA_DETALLE");
    // add require
    queryBuilder.addAttribute("CODIGO_CUARENTENA_DETALLE");
    queryBuilder.addAttribute("CODIGO_EXPEDIENTE");
    queryBuilder.addAttribute("CODIGO_ESTABLECIMIENTO");
    queryBuilder.addAttribute("CODIGO_TECNICO_PERSONA");
    queryBuilder.addAttribute("TIPO_DETALLE");
    queryBuilder.addAttribute("NUMERO_PSI");
    queryBuilder.addAttribute("SOURCE_PAIS_ID");
    queryBuilder.addAttribute("TARGET_PAIS_ID");
    queryBuilder.addAttribute("LUGAR_DETALLE");
    // query
    PreparedStatement prepared = this.connection.prepareStatement(queryBuilder.getInsert());
    prepared.setString(1, params.getId());
    prepared.setString(2, params.getExpedienteId());
    prepared.setString(3, params.getEstablishmentId());
    prepared.setString(4, params.getTechnicalId());
    prepared.setString(5, params.getType());
    prepared.setString(6, params.getNumberPSI());
    prepared.setString(7, params.getSourceCountryId());
    prepared.setString(8, params.getTargetCountryId());
    prepared.setString(9, params.getPlace());
    // execute
    prepared.execute();
    // reponse
    return params;
  }
}
