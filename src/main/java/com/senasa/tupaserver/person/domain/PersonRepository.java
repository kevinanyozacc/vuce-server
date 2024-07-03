package com.senasa.tupaserver.person.domain;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.person.domain.dtos.PersonListDto;

public interface PersonRepository {
  List<PersonMapper> listPeople(PersonListDto params);

  PersonMapper findPerson(PersonFindDto params);

  PersonEntity createPerson(PersonEntity person) throws SQLException, Exception;
}
