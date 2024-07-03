package com.senasa.tupaserver.product.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper extends ProductEntity {
  public ProductMapper() {
  }

  public ProductMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_PRODUCTO"));
    this.setArancelariaId(rs.getString("CODIGO_PARTIDA_ARANCELARIA"));
    this.setSpeciesId(rs.getString("CODIGO_ESPECIE"));
    this.setType(rs.getString("CODIGO_CLASE"));
    this.setName(rs.getString("NOMBRE_COMERCIAL_PRODUCTO"));
    this.setScientificName(rs.getString("NOMBRE_CIENTIFICO_PRODUCTO"));
    this.setState(rs.getString("ESTADO"));
    // arancela
    if (this.getArancelariaId() != null) {
      this.setArancelariaPartida(rs.getString("PARTIDA_ARANCELARIA"));
      this.setArancelariaName(rs.getString("DESCRIPCION_PART_ARANCELARIA"));
    }
    // species
    if (this.getSpeciesId() != null) {
      this.species = new SpeciesMapper();
      this.species.setId(rs.getString("CODIGO_CLASE"));
      this.species.setName(rs.getString("NOMB_SINO_SIN"));
    }
  }

  private String arancelariaPartida;
  private String arancelariaName;
  private SpeciesMapper species;

  public String getArancelariaPartida() {
    return this.arancelariaPartida;
  }

  public void setArancelariaPartida(String value) {
    this.arancelariaPartida = value;
  }

  public String getArancelariaName() {
    return this.arancelariaName;
  }

  public void setArancelariaName(String value) {
    this.arancelariaName = value;
  }

  public SpeciesMapper getSpecies() {
    return this.species;
  }

  public void setSpecies(SpeciesMapper value) {
    this.species = value;
  }
}
