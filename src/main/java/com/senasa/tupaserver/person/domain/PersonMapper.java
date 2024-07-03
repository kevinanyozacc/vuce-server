package com.senasa.tupaserver.person.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.senasa.tupaserver.documentType.domain.DocumentTypeMapper;
import com.senasa.tupaserver.ubigeo.domain.UbigeoMapper;

public class PersonMapper extends PersonEntity {
  public PersonMapper() {
  }

  public PersonMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("PERSONA_ID"));
    this.setNombreRazonSocial(rs.getString("NOMBRE_RAZON_SOCIAL"));
    this.setType(rs.getString("PERSONA_TIPO"));
    this.setDocumentTypeId(rs.getString("DOCUMENTO_TIPO"));
    this.setDocumentNumber(rs.getString("DOCUMENTO_NUMERO"));
    this.setLastName(rs.getString("APELLIDO_PATERNO"));
    this.setSecondaryName(rs.getString("APELLIDO_MATERNO"));
    this.setNames(rs.getString("NOMBRES"));
    this.setRuc(rs.getString("RUC"));
    this.setAddress(rs.getString("DIRECCION"));
    this.setDepartamentoId(rs.getString("DEPARTAMENTO_ID"));
    this.setProvinciaId(rs.getString("PROVINCIA_ID"));
    this.setDistritoId(rs.getString("DISTRITO_ID"));
    this.setCentroPobladoId(rs.getString("CENTRO_POBLADO_ID"));
    this.setPhone(rs.getString("TELEFONO"));
    this.setCellphone(rs.getString("TELEFONO_MOVIL"));
    this.setEmail(rs.getString("CORREO_ELECTRONICO"));
    this.setReferen(rs.getString("REFERENCIA"));
    this.setPaisId(rs.getString("PAIS_ID"));
    this.setDateOfBirth(rs.getString("FECHA_NACIMIENTO"));
    // validar ubigeo
    if (this.getDepartamentoId() != null) {
      this.ubigeo = new UbigeoMapper();
      this.ubigeo.setDepartamentoId(rs.getString("DEPARTAMENTO_ID"));
      this.ubigeo.setDepartamentoName(rs.getString("NOMB_DPTO_DPT"));
      this.ubigeo.setProvinciaId(rs.getString("PROVINCIA_ID"));
      this.ubigeo.setProvinciaName(rs.getString("NOMB_PROV_TPR"));
      this.ubigeo.setDistritoId(rs.getString("DISTRITO_ID"));
      this.ubigeo.setDistritoName(rs.getString("NOMB_DIST_TDI"));
      this.ubigeo.generateId();
    }
    // validar document type
    if (this.getDocumentTypeId() != null) {
      this.documentType = new DocumentTypeMapper(rs, index);
    }
  }

  private UbigeoMapper ubigeo;
  private DocumentTypeMapper documentType;

  public UbigeoMapper getUbigeo() {
    return this.ubigeo;
  }

  public void setUbigeo(UbigeoMapper value) {
    this.ubigeo = value;
  }

  public DocumentTypeMapper getDocumentType() {
    return this.documentType;
  }

  public void setDocumentType(DocumentTypeMapper value) {
    this.documentType = value;
  }
}
