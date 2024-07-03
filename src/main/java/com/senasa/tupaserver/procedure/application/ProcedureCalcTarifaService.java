package com.senasa.tupaserver.procedure.application;

import java.sql.SQLException;
import com.senasa.tupaserver.procedure.domain.ProcedureRepository;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaResponseDto;

public class ProcedureCalcTarifaService {
  public ProcedureCalcTarifaService(ProcedureRepository procedureRepository) {
    this.procedureRepository = procedureRepository;
  }

  ProcedureRepository procedureRepository;

  public ProcedureCalcTarifaResponseDto execute(ProcedureCalcTarifaDto params) throws SQLException {
    double total = this.procedureRepository.calcProcedureTarifa(params);
    ProcedureCalcTarifaResponseDto response = new ProcedureCalcTarifaResponseDto();
    response.setTotal(total);
    return response;
  }
}
