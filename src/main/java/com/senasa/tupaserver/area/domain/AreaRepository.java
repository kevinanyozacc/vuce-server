package com.senasa.tupaserver.area.domain;

import java.util.List;
import com.senasa.tupaserver.area.domain.dtos.AreaFindDto;
import com.senasa.tupaserver.area.domain.dtos.AreaListDto;

public interface AreaRepository {
  public List<AreaMapper> listAreas(AreaListDto params);

  public AreaMapper findArea(AreaFindDto params);
}
