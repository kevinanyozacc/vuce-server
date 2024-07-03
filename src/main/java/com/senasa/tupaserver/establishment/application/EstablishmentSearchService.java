package com.senasa.tupaserver.establishment.application;

import java.util.List;
import javax.validation.Valid;
import com.senasa.tupaserver.establishment.domain.EstablishmentMapper;
import com.senasa.tupaserver.establishment.domain.EstablishmentRepository;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentListDto;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentSearchDto;

public class EstablishmentSearchService {
  public EstablishmentSearchService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  EstablishmentRepository establishmentRepository;

  public List<EstablishmentMapper> execute(@Valid EstablishmentSearchDto params) throws Exception {
    EstablishmentListDto request = new EstablishmentListDto();
    if (params.getColumn().equals("name")) {
      request.setName(params.getValue());
    } else if (params.getColumn().equals("ownerName")) {
      request.setOwnerName(params.getValue());
    } else if (params.getColumn().equals("ownerRuc")) {
      request.setOwnerRuc(params.getValue());
    } else {
      throw new Exception("La busqueda no está permitida");
    }
    // search
    return this.establishmentRepository.listEstablishments(request);
  }
}
