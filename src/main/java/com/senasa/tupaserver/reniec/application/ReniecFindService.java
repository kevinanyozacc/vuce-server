package com.senasa.tupaserver.reniec.application;

import org.modelmapper.ModelMapper;
import com.senasa.tupaserver.reniec.domain.ReniecPersonEntity;
import com.senasa.tupaserver.reniec.domain.ReniecRepository;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosPorRUCResponse;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosReniecResponse;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import com.senasa.tupaserver.ubigeo.domain.DepartamentoEntity;
import com.senasa.tupaserver.ubigeo.domain.DistritoEntity;
import com.senasa.tupaserver.ubigeo.domain.ProvinciaEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
import com.senasa.tupaserver.ubigeo.domain.dtos.DepartamentoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.DistritoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.ProvinciaFindDto;

public class ReniecFindService {
  public ReniecFindService(
      ReniecRepository reniecRepository,
      UbigeoRepository ubigeoRepository,
      ModelMapper modelMapper) {
    this.reniecRepository = reniecRepository;
    this.ubigeoRepository = ubigeoRepository;
    this.modelMapper = modelMapper;
  }

  ReniecRepository reniecRepository;
  UbigeoRepository ubigeoRepository;
  ModelMapper modelMapper;

  public ReniecPersonEntity execute(String documentNumber, String type) throws ErrorNotFoundException {
    ReniecPersonEntity person;
    // validar type
    if ("RUC" == type) {
      ObtenerDatosPorRUCResponse request = this.reniecRepository.findPersonByRuc(documentNumber);
      if (request.getReturn() == null) {
        throw new ErrorNotFoundException("No se encontró el registro");
      } else if (request.getReturn().getDocumentoNumero().equals("")) {
        throw new ErrorNotFoundException("No se encontró el registro");
      }
      // mapping person
      person = this.modelMapper.map(request.getReturn(), ReniecPersonEntity.class);
    } else {
      ObtenerDatosReniecResponse request = this.reniecRepository.findPersonByDni(documentNumber);
      if (request.getReturn() == null) {
        throw new ErrorNotFoundException("No se encontró el registro");
      } else if (request.getReturn().getDocumentoNumero().equals("")) {
        throw new ErrorNotFoundException("No se encontró el registro");
      }
      // mapping person
      person = this.modelMapper.map(request.getReturn(), ReniecPersonEntity.class);
    }
    // departamento
    DepartamentoFindDto requestDpto = new DepartamentoFindDto();
    requestDpto.setName(person.getDepartamento());
    DepartamentoEntity departamento = this.ubigeoRepository.findDepartamento(requestDpto);
    // provincia
    ProvinciaFindDto requestProv = new ProvinciaFindDto();
    requestProv.setName(person.getProvincia());
    ProvinciaEntity porvincia = this.ubigeoRepository.findProvincia(requestProv);
    // distrito
    DistritoFindDto requestDist = new DistritoFindDto();
    requestDist.setName(person.getDistrito());
    DistritoEntity distrito = this.ubigeoRepository.findDistrito(requestDist);
    // settings
    if (departamento != null) {
      person.setDepartamentoId(departamento.getId());
    }
    if (porvincia != null) {
      person.setProvinciaId(porvincia.getId());
    }
    if (distrito != null) {
      person.setDistritoId(distrito.getId());
    }
    // response
    return person;
  }
}
