package com.senasa.tupaserver.detalle.application;

import org.modelmapper.ModelMapper;
import com.senasa.tupaserver.detalle.domain.DetalleMapper;
import com.senasa.tupaserver.detalle.domain.DetalleRepository;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindDto;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindResponseDto;
import com.senasa.tupaserver.establishment.domain.EstablishmentMapper;
import com.senasa.tupaserver.establishment.domain.EstablishmentRepository;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentFindDto;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;

public class DetalleFindService {
  public DetalleFindService(
      DetalleRepository detalleRepository,
      EstablishmentRepository establishmentRepository,
      PersonRepository personRepository,
      ModelMapper modelMapper) {
    this.detalleRepository = detalleRepository;
    this.establishmentRepository = establishmentRepository;
    this.personRepository = personRepository;
    this.modelMapper = modelMapper;
  }

  DetalleRepository detalleRepository;
  EstablishmentRepository establishmentRepository;
  PersonRepository personRepository;
  ModelMapper modelMapper;

  public DetalleFindResponseDto execute(DetalleFindDto params) throws ErrorNotFoundException {
    DetalleMapper detalle = this.detalleRepository.findDetalle(params);
    if (detalle == null) {
      throw new ErrorNotFoundException("No se encontró el detalle del expediente");
    }
    // obtener establishment
    EstablishmentFindDto establishmentRequest = new EstablishmentFindDto();
    establishmentRequest.setId(detalle.getEstablishmentId());
    EstablishmentMapper establishment = this.establishmentRepository.findEstablishment(establishmentRequest);
    // obtener technical
    PersonFindDto personRequest = new PersonFindDto();
    personRequest.setId(detalle.getTechnicalId());
    PersonMapper technical = this.personRepository.findPerson(personRequest);
    // response
    DetalleFindResponseDto response = new DetalleFindResponseDto();
    response.setId(detalle.getId());
    response.setExpedienteId(detalle.getExpedienteId());
    response.setEstablishmentId(detalle.getEstablishmentId());
    response.setTechnicalId(detalle.getTechnicalId());
    response.setType(detalle.getType());
    response.setNumberPSI(detalle.getNumberPSI());
    response.setSourceCountryId(detalle.getSourceCountryId());
    response.setTargetCountryId(detalle.getTargetCountryId());
    response.setPlace(detalle.getPlace());
    response.setEstablishment(establishment);
    response.setTechnical(technical);
    return response;
  }
}
