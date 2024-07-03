package com.senasa.tupaserver.ubigeo.application;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.DepartamentoEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
import com.senasa.tupaserver.ubigeo.domain.dtos.DepartamentoListDto;

public class UbigeoDepartamentoListService {
  public UbigeoDepartamentoListService(UbigeoRepository ubigeRepository) {
    this.ubigeRepository = ubigeRepository;
  }

  UbigeoRepository ubigeRepository;

  public List<DepartamentoEntity> execute(DepartamentoListDto request) {
    return this.ubigeRepository.listDepartamentos(request);
  }
}
