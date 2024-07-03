package com.senasa.tupaserver.representante.application;

import javax.validation.Valid;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;
import com.senasa.tupaserver.representante.domain.RepresentanteRepository;
import com.senasa.tupaserver.representante.domain.dtos.RepresentantePaginateDto;
import com.senasa.tupaserver.shared.sql.PaginateResponse;

public class RepresentantePaginateService {
  public RepresentantePaginateService(RepresentanteRepository representanteRepository) {
    this.representanteRepository = representanteRepository;
  }

  private RepresentanteRepository representanteRepository;

  public PaginateResponse<RepresentanteMapper> execute(@Valid RepresentantePaginateDto request) throws Exception {
    return this.representanteRepository.paginateRepresentantes(request);
  }
}
