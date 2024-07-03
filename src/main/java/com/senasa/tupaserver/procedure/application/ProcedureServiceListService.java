package com.senasa.tupaserver.procedure.application;

import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;
import com.senasa.tupaserver.procedure.domain.ProcedureRepository;
import com.senasa.tupaserver.procedure.domain.ProcedureServiceMapper;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;

public class ProcedureServiceListService {
  public ProcedureServiceListService(ProcedureRepository procedureRepository) {
    this.procedureRepository = procedureRepository;
  }

  ProcedureRepository procedureRepository;

  public List<ProcedureServiceMapper> execute(@Valid ProcedureFindDto params) throws SQLException {
    return this.procedureRepository.listProcedureServices(params);
  }
}
