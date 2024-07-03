package com.senasa.tupaserver.representante.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.representante.application.RepresentantePaginateService;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;
import com.senasa.tupaserver.representante.domain.dtos.RepresentantePaginateDto;
import com.senasa.tupaserver.representante.infrastructure.repository.RepresentanteJpaRepositoryImpl;
import com.senasa.tupaserver.shared.sql.PaginateResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/representantes")
public class RepresentanteHttpController {
  @Autowired
  RepresentanteJpaRepositoryImpl representanteRepository;

  @GetMapping(path = { "", "/" })
  public PaginateResponse<RepresentanteMapper> paginateRepresentante(
      @Valid RepresentantePaginateDto params)
      throws Exception {
    RepresentantePaginateService service = new RepresentantePaginateService(representanteRepository);
    return service.execute(params);
  }
}
