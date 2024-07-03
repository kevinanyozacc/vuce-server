package com.senasa.tupaserver.ubigeo.application;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.DistritoEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
import com.senasa.tupaserver.ubigeo.domain.dtos.DistritoListDto;

public class UbigeoDistritoListService {
  public UbigeoDistritoListService(UbigeoRepository ubigeRepository) {
    this.ubigeRepository = ubigeRepository;
  }

  UbigeoRepository ubigeRepository;

  public List<DistritoEntity> execute(DistritoListDto request) {
    return this.ubigeRepository.listDistritos(request);
  }
}
