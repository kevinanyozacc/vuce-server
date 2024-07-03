package com.senasa.tupaserver.area.application;

import com.senasa.tupaserver.area.domain.AreaMapper;
import com.senasa.tupaserver.area.domain.AreaRepository;
import com.senasa.tupaserver.area.domain.dtos.AreaFindDto;
import com.senasa.tupaserver.procedure.domain.ProcedureMapper;
import com.senasa.tupaserver.procedure.domain.ProcedureRepository;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;

import java.util.List;

public class AreaProcedureListService {
  public AreaProcedureListService(AreaRepository areaRepository, ProcedureRepository procedureRepository) {
    this.areaRepository = areaRepository;
    this.procedureRepository = procedureRepository;
  }

  AreaRepository areaRepository;
  ProcedureRepository procedureRepository;

  public List<ProcedureMapper> execute(AreaFindDto params) throws Exception {
    AreaMapper areaMapper = this.areaRepository.findArea(params);
    // validate area
    if (areaMapper == null) {
      throw new Exception("No se encontró el area");
    }
    // list procedure
    ProcedureFindDto request = new ProcedureFindDto();
    request.setAreaId(areaMapper.getId());
    return this.procedureRepository.listProcedures(request);
  }
}
