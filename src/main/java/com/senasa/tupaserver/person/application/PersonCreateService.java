package com.senasa.tupaserver.person.application;

import java.sql.SQLException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import com.senasa.tupaserver.person.domain.PersonEntity;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonCreateDto;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorFieldEntity;
import com.senasa.tupaserver.shared.http.domain.ErrorValidateException;

public class PersonCreateService {
  public PersonCreateService(PersonRepository personRepository, ModelMapper modelMapper) {
    this.personRepository = personRepository;
    this.modelMapper = modelMapper;
  }

  private PersonRepository personRepository;
  private ModelMapper modelMapper;
  private PersonEntity person;

  public PersonMapper execute(@Valid PersonCreateDto request) throws SQLException, Exception {
    this.person = this.modelMapper.map(request, PersonEntity.class);
    // validar persona juridica
    if (request.getType().equals("JURIDICA")) {
      person.setLastName(null);
      person.setSecondaryName(null);
      person.setNames(null);
      person.setRuc(person.getDocumentNumber());
    } else {
      // validar persona natural
      this.validatePersonNatural();
    }
    // crear person
    PersonEntity personData = this.personRepository.createPerson(person);
    PersonFindDto requestFind = new PersonFindDto();
    requestFind.setId(personData.getId());
    PersonFindService serviceFind = new PersonFindService(this.personRepository);
    return serviceFind.execute(requestFind);
  }

  private void validatePersonNatural() throws ErrorValidateException {
    if (this.person.getLastName() == null) {
      throw new ErrorValidateException(new ErrorFieldEntity("lastName", "El campo está vacio"));
    }

    if (this.person.getNames() == null) {
      throw new ErrorValidateException(new ErrorFieldEntity("names", "El campo está vacio"));
    }

    if (this.person.getGender() == null) {
      throw new ErrorValidateException(new ErrorFieldEntity("gender", "El campo está vacio"));
    }
  }
}
