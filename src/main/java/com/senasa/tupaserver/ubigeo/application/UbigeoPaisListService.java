package com.senasa.tupaserver.ubigeo.application;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.PaisEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;

public class UbigeoPaisListService {
  public UbigeoPaisListService(UbigeoRepository ubigeoRepository) {
    this.ubigeoRepository = ubigeoRepository;
  }

  private UbigeoRepository ubigeoRepository;

  public List<PaisEntity> execute() {
    return this.ubigeoRepository.listPaises();
  }
}
