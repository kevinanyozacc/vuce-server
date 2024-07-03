package com.senasa.tupaserver.documentType.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentTypeMapper extends DocumentTypeEntity {
  public DocumentTypeMapper() {
  }

  public DocumentTypeMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_DOCUMENTO"));
    this.setName(rs.getString("DESCRIPCION_TIPO_DOCUMENTO"));
    this.setDescription(rs.getString("DESCRIPCION_COMPLETA"));
    this.setState(rs.getString("ESTADO"));
  }
}
