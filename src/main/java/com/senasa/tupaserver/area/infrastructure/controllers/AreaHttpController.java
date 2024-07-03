package com.senasa.tupaserver.area.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.area.domain.AreaMapper;
import com.senasa.tupaserver.area.domain.dtos.AreaFindDto;
import com.senasa.tupaserver.area.domain.dtos.AreaListDto;
import com.senasa.tupaserver.area.infrastructure.repository.AreaJpaRepository;
import com.senasa.tupaserver.procedure.domain.ProcedureMapper;
import com.senasa.tupaserver.procedure.infrastructure.repository.ProcedureJpaRepository;
import com.senasa.tupaserver.area.application.AreaListService;
import com.senasa.tupaserver.area.application.AreaProcedureListService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/areas")
public class AreaHttpController {
  @Autowired
  AreaJpaRepository areaRepository;

  @Autowired
  ProcedureJpaRepository procedureRepository;

  @GetMapping(path = { "", "/" })
  public List<AreaMapper> listAreas() {
    AreaListService service = new AreaListService(this.areaRepository);
    return service.execute(new AreaListDto());
  }

  @GetMapping("/{id}/procedures")
  public List<ProcedureMapper> listProcedures(@PathVariable("id") String id) throws Exception {
    AreaFindDto request = new AreaFindDto();
    request.setId(id);
    AreaProcedureListService service = new AreaProcedureListService(this.areaRepository, this.procedureRepository);
    return service.execute(request);
  }
}
