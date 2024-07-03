package com.senasa.tupaserver.person.infrastructure.controllers;

import java.sql.SQLException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.person.application.PersonCreateService;
import com.senasa.tupaserver.person.application.PersonFindService;
import com.senasa.tupaserver.person.application.PersonListService;
import com.senasa.tupaserver.person.application.PersonRepresentanteListService;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.dtos.PersonCreateDto;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.person.domain.dtos.PersonListDto;
import com.senasa.tupaserver.person.infrastructure.repository.PersonJpaRepositoryImpl;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;
import com.senasa.tupaserver.representante.infrastructure.repository.RepresentanteJpaRepositoryImpl;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/people")
public class PersonHttpController {
  @Autowired
  private PersonJpaRepositoryImpl personRepository;

  @Autowired
  private RepresentanteJpaRepositoryImpl representanteRepository;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/{personId}")
  public PersonMapper findPersonById(@PathVariable("personId") String id) throws Exception {
    PersonFindDto params = new PersonFindDto();
    params.setId(id);
    PersonFindService service = new PersonFindService(this.personRepository);
    return service.execute(params);
  }

  @PostMapping(path = { "", "/" })
  public PersonMapper createPerson(@RequestBody @Valid PersonCreateDto request) throws SQLException, Exception {
    PersonCreateService service = new PersonCreateService(
        this.personRepository,
        this.modelMapper);
    return service.execute(request);
  }

  @GetMapping("/{id}/representantes")
  public List<RepresentanteMapper> listRepresentanteString(@PathVariable("id") String id)
      throws ErrorNotFoundException {
    PersonFindDto request = new PersonFindDto();
    request.setId(id);
    PersonRepresentanteListService service = new PersonRepresentanteListService(
        this.personRepository,
        this.representanteRepository);
    return service.execute(request);
  }

  @GetMapping("/{documentNumber}/search/{documentType}")
  public List<PersonMapper> findSearch(
      @PathVariable String documentNumber,
      @PathVariable String documentType) throws Exception {
    PersonListDto params = new PersonListDto();
    params.setDocumentNumber(documentNumber);
    params.setDocumentTypeId(documentType);
    PersonListService service = new PersonListService(this.personRepository);
    return service.execute(params);
  }

  @GetMapping("/{querySearch}/searchNames")
  public List<PersonMapper> findSearchNames(
      @PathVariable String querySearch) throws Exception {
    PersonListDto params = new PersonListDto();
    params.setQuerySearch(querySearch);
    PersonListService service = new PersonListService(this.personRepository);
    return service.execute(params);
  }
}
