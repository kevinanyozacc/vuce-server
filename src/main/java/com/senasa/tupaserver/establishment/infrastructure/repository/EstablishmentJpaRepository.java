package com.senasa.tupaserver.establishment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senasa.tupaserver.establishment.domain.EstablishmentEntity;

public interface EstablishmentJpaRepository extends JpaRepository<EstablishmentEntity, String> {
}
