package com.senasa.tupaserver.person.infrastructure.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senasa.tupaserver.person.domain.PersonEntity;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, String> {
  public PersonEntity findByDocumentNumberAndDocumentTypeId(String documentNumber, String documentType);

  public List<PersonEntity> findByNombreRazonSocialIgnoreCaseContains(String value);
}
