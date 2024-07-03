package com.senasa.tupaserver.person.application;

import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonListDto;
import javax.validation.Valid;
import java.util.List;

public class PersonListService {
  private PersonRepository personRepository;

  public PersonListService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<PersonMapper> execute(@Valid PersonListDto params) throws Exception {
    return this.personRepository.listPeople(params);
  }
}
