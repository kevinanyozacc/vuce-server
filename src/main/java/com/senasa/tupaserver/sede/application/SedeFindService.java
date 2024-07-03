package com.senasa.tupaserver.sede.application;

import com.senasa.tupaserver.sede.domain.SedeMapper;
import com.senasa.tupaserver.sede.domain.SedeRepository;
import com.senasa.tupaserver.sede.domain.dtos.SedeFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;

public class SedeFindService {
  public SedeFindService(SedeRepository sedeRepository) {
    this.sedeRepository = sedeRepository;
  }

  SedeRepository sedeRepository;

  public SedeMapper execute(SedeFindDto params) throws ErrorNotFoundException {
    SedeMapper sede = this.sedeRepository.findSede(params);
    if (sede == null) {
      throw new ErrorNotFoundException("No se encontró el registro");
    }
    return sede;
  }
}
