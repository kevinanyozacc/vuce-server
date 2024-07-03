package com.senasa.tupaserver.procedure.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.procedure.application.ProcedureCalcTarifaService;
import com.senasa.tupaserver.procedure.application.ProcedureInfoListService;
import com.senasa.tupaserver.procedure.application.ProcedureServiceListService;
import com.senasa.tupaserver.procedure.domain.ProcedureInfoMapper;
import com.senasa.tupaserver.procedure.domain.ProcedureServiceMapper;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaResponseDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureInfoDto;
import com.senasa.tupaserver.procedure.infrastructure.repository.ProcedureJpaRepository;
import java.util.List;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/procedures")
public class ProcedureHttpController {
  @Autowired
  ProcedureJpaRepository procedureRepository;

  @GetMapping("{id}/services")
  public List<ProcedureServiceMapper> listServices(@PathVariable("id") String id) throws SQLException {
    ProcedureFindDto request = new ProcedureFindDto();
    request.setId(id);
    ProcedureServiceListService service = new ProcedureServiceListService(this.procedureRepository);
    return service.execute(request);
  }

  @GetMapping("{id}/services/{serviceId}")
  public List<ProcedureInfoMapper> findServices(
      @PathVariable("id") String id,
      @PathVariable("serviceId") String serviceId) throws SQLException {
    ProcedureInfoDto request = new ProcedureInfoDto();
    request.setProcedureId(id);
    request.setServiceId(serviceId);
    ProcedureInfoListService service = new ProcedureInfoListService(this.procedureRepository);
    return service.execute(request);
  }

  @GetMapping("{id}/services/{serviceId}/calcTarifa")
  public ProcedureCalcTarifaResponseDto calcTarifa(
      @PathVariable("serviceId") String serviceId,
      @RequestParam String amount)
      throws SQLException {
    ProcedureCalcTarifaDto request = new ProcedureCalcTarifaDto();
    request.setServiceId(serviceId);
    request.setAmount(1);
    ProcedureCalcTarifaService service = new ProcedureCalcTarifaService(this.procedureRepository);
    return service.execute(request);
  }
}
