package com.senasa.tupaserver.reniec.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.reniec.application.ReniecFindService;
import com.senasa.tupaserver.reniec.domain.ReniecPersonEntity;
import com.senasa.tupaserver.reniec.infrastructure.repository.ReniecSoapRepository;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import com.senasa.tupaserver.ubigeo.infrastructure.repository.UbigeoJpaRepositoryImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reniec")
public class ReniecHttpController {

  @Autowired
  ReniecSoapRepository reniecRepository;

  @Autowired
  UbigeoJpaRepositoryImpl ubigeoRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/searchByDni/{documentNumber}")
  public ReniecPersonEntity searchByDni(@PathVariable String documentNumber) throws ErrorNotFoundException {
    ReniecFindService service = new ReniecFindService(
        this.reniecRepository,
        this.ubigeoRepository,
        this.modelMapper);
    return service.execute(documentNumber, "DNI");
  }

  @GetMapping("/searchByRuc/{documentNumber}")
  public ReniecPersonEntity searchByRuc(@PathVariable String documentNumber) throws ErrorNotFoundException {
    ReniecFindService service = new ReniecFindService(
        this.reniecRepository,
        this.ubigeoRepository,
        this.modelMapper);
    return service.execute(documentNumber, "RUC");
  }
}
