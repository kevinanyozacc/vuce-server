package com.senasa.tupaserver.representante.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senasa.tupaserver.representante.domain.RepresentanteEntity;

@Repository
public interface RepresentanteJpaRepository extends JpaRepository<RepresentanteEntity, String> {
}
