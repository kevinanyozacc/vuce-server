package com.senasa.tupaserver.establishment.application;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import com.senasa.tupaserver.establishment.domain.EstablishmentEntity;
import com.senasa.tupaserver.establishment.domain.EstablishmentRepository;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentCreateDto;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentFindDto;

public class EstablishmentCreateService {
  public EstablishmentCreateService(EstablishmentRepository establishmentRepository, ModelMapper modelMapper) {
    this.establishmentRepository = establishmentRepository;
    this.modelMapper = modelMapper;
  }

  EstablishmentRepository establishmentRepository;
  ModelMapper modelMapper;

  public EstablishmentEntity execute(@Valid EstablishmentCreateDto request) {
    EstablishmentEntity value = this.modelMapper.map(request, EstablishmentEntity.class);
    EstablishmentEntity result = this.establishmentRepository.createEstablishment(value);
    EstablishmentFindDto params = new EstablishmentFindDto();
    params.setId(result.getId());
    return this.establishmentRepository.findEstablishment(params);
  }
}
