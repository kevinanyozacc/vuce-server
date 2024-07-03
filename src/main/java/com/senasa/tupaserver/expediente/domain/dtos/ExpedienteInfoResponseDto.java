package com.senasa.tupaserver.expediente.domain.dtos;

import java.util.ArrayList;
import java.util.List;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaMapper;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindResponseDto;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;

public class ExpedienteInfoResponseDto {
  private PersonMapper person;
  private RepresentanteMapper representante;
  private DetalleFindResponseDto detalle;
  private List<CuarentenaMapper> cuarentenas = new ArrayList<CuarentenaMapper>();

  public PersonMapper getPerson() {
    return this.person;
  }

  public void setPerson(PersonMapper value) {
    this.person = value;
  }

  public RepresentanteMapper getRepresentante() {
    return this.representante;
  }

  public void setRepresentante(RepresentanteMapper value) {
    this.representante = value;
  }

  public DetalleFindResponseDto getDetalle() {
    return this.detalle;
  }

  public void setDetalle(DetalleFindResponseDto value) {
    this.detalle = value;
  }

  public List<CuarentenaMapper> getCuarentenas() {
    return this.cuarentenas;
  }

  public void setCuarentenas(List<CuarentenaMapper> value) {
    this.cuarentenas = value;
  }
}
