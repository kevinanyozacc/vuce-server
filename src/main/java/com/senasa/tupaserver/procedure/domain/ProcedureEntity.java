package com.senasa.tupaserver.procedure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDIMIENTO_TUPA", schema = "FINALBPM")
public class ProcedureEntity {
  @Id
  @Column(name = "CODIGO_PROCEDIMIENTO_TUPA")
  private String id;

  @Column(name = "DESCRIPCION_PROCEDIMIETO_TUPA")
  private String name;

  @Column(name = "Indicador_Procedimiento_Espe")
  private String indicador;

  @Column(name = "ESTADO")
  private String state;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getIndicador() {
    return this.indicador;
  }

  public void setIndicador(String value) {
    this.indicador = value;
  }
}
