package com.senasa.tupaserver.expediente.application;

import java.sql.SQLException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.senasa.tupaserver.cuarentena.domain.CuarentenaMapper;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaRepository;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.detalle.application.DetalleFindService;
import com.senasa.tupaserver.detalle.domain.DetalleRepository;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindDto;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindResponseDto;
import com.senasa.tupaserver.establishment.domain.EstablishmentRepository;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteInfoResponseDto;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.representante.domain.RepresentanteRepository;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;

public class ExpedienteInfoService {
  public ExpedienteInfoService(
      ExpedienteRepository expedienteRepository,
      PersonRepository personRepository,
      RepresentanteRepository representanteRepository,
      EstablishmentRepository establishmentRepository,
      DetalleRepository detalleRepository,
      CuarentenaRepository cuarentenaRepository,
      ModelMapper modelMapper) {
    this.expedienteRepository = expedienteRepository;
    this.personRepository = personRepository;
    this.representanteRepository = representanteRepository;
    this.establishmentRepository = establishmentRepository;
    this.detalleRepository = detalleRepository;
    this.cuarentenaRepository = cuarentenaRepository;
    this.modelMapper = modelMapper;
  }

  ExpedienteRepository expedienteRepository;
  PersonRepository personRepository;
  RepresentanteRepository representanteRepository;
  EstablishmentRepository establishmentRepository;
  DetalleRepository detalleRepository;
  CuarentenaRepository cuarentenaRepository;
  ModelMapper modelMapper;

  public ExpedienteInfoResponseDto execute(ExpedienteFindDto params) throws SQLException, ErrorNotFoundException {
    ExpedienteMapper expediente = this.expedienteRepository.findExpediente(params);
    if (expediente == null) {
      throw new ErrorNotFoundException("No se encontró el expediente");
    }
    // obtener solicitante
    PersonFindDto personRequest = new PersonFindDto();
    personRequest.setId(expediente.getPersonId());
    PersonMapper person = this.personRepository.findPerson(personRequest);
    // obtener representante
    // RepresentanteFindDto requestRepresentante = new RepresentanteFindDto();
    // requestRepresentante.setId(expediente.getRepresentanteId());
    // RepresentanteMapper representante =
    // this.representanteRepository.findRepresentante(requestRepresentante);
    // listar cuarentenas
    CuarentenaListDto cuarentenaListDto = new CuarentenaListDto();
    cuarentenaListDto.setExpedienteId(expediente.getId());
    List<CuarentenaMapper> cuarentenas = this.cuarentenaRepository.listCuarentenas(cuarentenaListDto);
    // obtener detalle
    DetalleFindDto detalleRequest = new DetalleFindDto();
    detalleRequest.setExpedienteId(expediente.getId());
    DetalleFindResponseDto detalle = new DetalleFindService(
        this.detalleRepository,
        this.establishmentRepository,
        this.personRepository,
        this.modelMapper)
        .execute(detalleRequest);
    // response
    ExpedienteInfoResponseDto response = new ExpedienteInfoResponseDto();
    response.setPerson(person);
    response.setDetalle(detalle);
    response.setCuarentenas(cuarentenas);
    // response.setRepresentante(representante);
    return response;
  }
}
