package com.senasa.tupaserver.detalle.domain.dtos;

import com.senasa.tupaserver.detalle.domain.DetalleMapper;
import com.senasa.tupaserver.establishment.domain.EstablishmentMapper;
import com.senasa.tupaserver.person.domain.PersonMapper;

public class DetalleFindResponseDto extends DetalleMapper {
  private EstablishmentMapper establishment;
  private PersonMapper technical;

  public EstablishmentMapper getEstablishment() {
    return this.establishment;
  }

  public void setEstablishment(EstablishmentMapper value) {
    this.establishment = value;
  }

  public PersonMapper getTechnical() {
    return this.technical;
  }

  public void setTechnical(PersonMapper value) {
    this.technical = value;
  }
}
