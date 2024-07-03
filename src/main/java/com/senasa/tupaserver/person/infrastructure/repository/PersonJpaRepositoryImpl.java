package com.senasa.tupaserver.person.infrastructure.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.person.domain.PersonEntity;
import com.senasa.tupaserver.person.domain.PersonMapper;
import com.senasa.tupaserver.person.domain.PersonRepository;
import com.senasa.tupaserver.person.domain.dtos.PersonFindDto;
import com.senasa.tupaserver.person.domain.dtos.PersonListDto;
import com.senasa.tupaserver.person.infrastructure.repository.jdbc.PersonSelectJdbc;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class PersonJpaRepositoryImpl implements PersonRepository {
  @Autowired
  PersonJpaRepository repository;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  ModelMapper modelMapper;

  @SuppressWarnings("null")
  private PersonEntity persists(PersonEntity person) throws SQLException {
    String sql = "CALL PCKG_PERSONA.Sp_Registrar_Persona_Validado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    Connection connection = this.jdbcTemplate.getDataSource().getConnection();
    CallableStatement cs = connection.prepareCall(sql);
    cs.registerOutParameter(1, OracleTypes.VARCHAR);
    cs.setString(1, person.getId());
    cs.setString(2, person.getNombreRazonSocial());
    cs.setString(3, person.getType().toString());
    cs.setString(4, person.getDocumentTypeId());
    cs.setString(5, person.getDocumentNumber());
    cs.setString(6, person.getRuc());
    cs.setString(7, person.getAddress());
    cs.setString(8, person.getDepartamentoId());
    cs.setString(9, person.getProvinciaId());
    cs.setString(10, person.getDistritoId());
    cs.setString(11, person.getPhone());
    cs.setString(12, person.getCellphone());
    cs.setString(13, person.getEmail());
    cs.setString(14, person.getDateOfBirth());
    cs.setString(15, person.getAddressReferen());
    cs.setString(16, person.getHighDate());
    cs.setString(17, person.getLowDate());
    cs.setString(18, person.getTradename());
    cs.setString(19, person.getLegalState());
    cs.setString(20, person.getSyncState());
    cs.setString(21, person.getSyncDate());
    cs.setString(22, person.getUserCreated());
    System.out.println(cs.toString());
    cs.execute();
    person.setId(cs.getString(1));
    return person;
  }

  @Override
  public List<PersonMapper> listPeople(PersonListDto params) {
    QueryBuilderSql queryBuilder = new PersonSelectJdbc().query(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new PersonMapper(row, index));
  }

  @Override
  public PersonMapper findPerson(PersonFindDto params) {
    PersonListDto tmpParams = this.modelMapper.map(params, PersonListDto.class);
    QueryBuilderSql queryBuilder = new PersonSelectJdbc().query(tmpParams);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new PersonMapper(row, index))
        .stream()
        .findFirst()
        .get();
  }

  @Override
  public PersonEntity createPerson(PersonEntity person) throws Exception {
    try {
      return this.persists(person);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new Exception("No se pudo registrar la persona");
    }
  }
}