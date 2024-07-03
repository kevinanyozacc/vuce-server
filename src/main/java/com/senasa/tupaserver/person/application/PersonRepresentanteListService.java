package com.senasa.tupaserver.person.application;

import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;
import com.senasa.tupaserver.representante.domain.RepresentanteRepository;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteListDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import java.util.List;

public class PersonRepresentanteListService {
  public PersonRepresentanteListService(
      PersonRepository personRepository,
      RepresentanteRepository representanteRepository) {
    this.personRepository = personRepository;
    this.representanteRepository = representanteRepository;
  }

  PersonRepository personRepository;
  RepresentanteRepository representanteRepository;

  public List<RepresentanteMapper> execute(PersonFindDto params) throws ErrorNotFoundException {
    PersonMapper personMapper = this.personRepository.findPerson(params);
    if (personMapper == null) {
      throw new ErrorNotFoundException("No se encontró el registro");
    }
    RepresentanteListDto request = new RepresentanteListDto();
    request.setPersonId(personMapper.getId());
    return this.representanteRepository.listRepresentantes(request);
  }
}
