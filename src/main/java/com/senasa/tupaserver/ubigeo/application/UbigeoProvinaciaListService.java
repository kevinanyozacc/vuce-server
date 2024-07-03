package com.senasa.tupaserver.ubigeo.application;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.ProvinciaEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
import com.senasa.tupaserver.ubigeo.domain.dtos.ProvinciaListDto;

public class UbigeoProvinaciaListService {
  public UbigeoProvinaciaListService(UbigeoRepository ubigeRepository) {
    this.ubigeRepository = ubigeRepository;
  }

  UbigeoRepository ubigeRepository;

  public List<ProvinciaEntity> execute(ProvinciaListDto request) {
    return this.ubigeRepository.listProvincias(request);
  }
}
