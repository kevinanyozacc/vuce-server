package com.senasa.tupaserver.establishment.domain;

import java.util.List;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentFindDto;
import com.senasa.tupaserver.establishment.domain.dtos.EstablishmentListDto;

public interface EstablishmentRepository {
  public EstablishmentEntity createEstablishment(EstablishmentEntity value);

  public EstablishmentMapper findEstablishment(EstablishmentFindDto params);

  public List<EstablishmentMapper> listEstablishments(EstablishmentListDto params);
}
