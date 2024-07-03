package com.senasa.tupaserver.person.application;

import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import javax.validation.Valid;

public class PersonFindService {
  private PersonRepository personRepository;

  public PersonFindService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public PersonMapper execute(@Valid PersonFindDto params) throws Exception {
    PersonMapper person = this.personRepository.findPerson(params);
    if (person == null) {
      throw new ErrorNotFoundException("No se encontró el registro");
    }
    return person;
  }
}
