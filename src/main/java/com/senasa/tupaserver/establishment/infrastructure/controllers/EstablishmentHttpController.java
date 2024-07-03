package com.senasa.tupaserver.establishment.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.establishment.application.EstablishmentCreateService;
import com.senasa.tupaserver.establishment.application.EstablishmentSearchService;
import com.senasa.tupaserver.establishment.domain.EstablishmentEntity;
import com.senasa.tupaserver.establishment.domain.EstablishmentMapper;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentCreateDto;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentSearchDto;
import com.senasa.tupaserver.establishment.infrastructure.repository.EstablishmentJpaRepositoryImpl;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RequestMapping("api/establishments")
@RestController
public class EstablishmentHttpController {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  EstablishmentJpaRepositoryImpl establishmentRepository;

  @GetMapping("/search/{column}/type/{value}")
  public List<EstablishmentMapper> searchEstablishments(
      @PathVariable("column") String column,
      @PathVariable("value") String value) throws Exception {
    EstablishmentSearchDto request = new EstablishmentSearchDto();
    request.setColumn(column);
    request.setValue(value);
    EstablishmentSearchService service = new EstablishmentSearchService(this.establishmentRepository);
    return service.execute(request);
  }

  @PostMapping(path = { "", "/" })
  public EstablishmentEntity createEstablishment(@RequestBody EstablishmentCreateDto request) {
    EstablishmentCreateService service = new EstablishmentCreateService(
        this.establishmentRepository,
        this.modelMapper);
    return service.execute(request);
  }
}
