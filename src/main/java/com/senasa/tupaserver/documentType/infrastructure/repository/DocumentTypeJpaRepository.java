package com.senasa.tupaserver.documentType.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senasa.tupaserver.documentType.domain.DocumentTypeEntity;

@Repository
public interface DocumentTypeJpaRepository extends JpaRepository<DocumentTypeEntity, String> {
}
