package com.senasa.tupaserver.sede.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.sede.application.SedeFindService;
import com.senasa.tupaserver.sede.application.SedeListService;
import com.senasa.tupaserver.sede.domain.SedeMapper;
import com.senasa.tupaserver.sede.domain.dtos.SedeFindDto;
import com.senasa.tupaserver.sede.infrastructure.repository.SedeJpaRepository;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/sedes")
public class SedeHttpController {
  @Autowired
  SedeJpaRepository sedeRepository;

  @GetMapping(path = { "", "/" })
  public List<SedeMapper> listSedes() {
    SedeListService service = new SedeListService(this.sedeRepository);
    return service.execute();
  }

  @GetMapping("/{id}")
  public SedeMapper getMethodName(@PathVariable("id") String id) throws ErrorNotFoundException {
    SedeFindDto params = new SedeFindDto();
    params.setId(id);
    SedeFindService service = new SedeFindService(this.sedeRepository);
    return service.execute(params);
  }

}
