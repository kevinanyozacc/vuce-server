package com.senasa.tupaserver.ubigeo.application;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.PobladoEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
import com.senasa.tupaserver.ubigeo.domain.dtos.PobladoListDto;

public class UbigeoPobladoListService {
  public UbigeoPobladoListService(UbigeoRepository ubigeRepository) {
    this.ubigeRepository = ubigeRepository;
  }

  UbigeoRepository ubigeRepository;

  public List<PobladoEntity> execute(PobladoListDto request) {
    System.out.println(request);
    return this.ubigeRepository.listPoblados(request);
  }
}
