package com.senasa.tupaserver.sede.application;

import com.senasa.tupaserver.sede.domain.SedeMapper;
import com.senasa.tupaserver.sede.domain.SedeRepository;
import java.util.List;

public class SedeListService {
  public SedeListService(SedeRepository sedeRepository) {
    this.sedeRepository = sedeRepository;
  }

  SedeRepository sedeRepository;

  public List<SedeMapper> execute() {
    return this.sedeRepository.listSedes();
  }
}
