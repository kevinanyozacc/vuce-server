package com.senasa.tupaserver.sede.domain;

import java.util.List;

import com.senasa.tupaserver.sede.domain.dtos.SedeFindDto;

public interface SedeRepository {
  public List<SedeMapper> listSedes();

  public SedeMapper findSede(SedeFindDto params);
}
