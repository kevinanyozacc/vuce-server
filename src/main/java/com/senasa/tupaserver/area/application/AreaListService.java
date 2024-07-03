package com.senasa.tupaserver.area.application;

import com.senasa.tupaserver.area.domain.AreaMapper;
import com.senasa.tupaserver.area.domain.AreaRepository;
import com.senasa.tupaserver.area.domain.dtos.AreaListDto;

import java.util.List;

public class AreaListService {
  public AreaListService(AreaRepository areaRepository) {
    this.areaRepository = areaRepository;
  }

  AreaRepository areaRepository;

  public List<AreaMapper> execute(AreaListDto params) {
    params.setState("ACTIVO");
    return this.areaRepository.listAreas(params);
  }
}
