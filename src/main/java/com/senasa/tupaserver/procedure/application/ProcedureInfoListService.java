package com.senasa.tupaserver.procedure.application;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.procedure.domain.ProcedureInfoMapper;
import com.senasa.tupaserver.procedure.domain.ProcedureRepository;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureInfoDto;

public class ProcedureInfoListService {
  public ProcedureInfoListService(ProcedureRepository procedureRepository) {
    this.procedureRepository = procedureRepository;
  }

  ProcedureRepository procedureRepository;

  public List<ProcedureInfoMapper> execute(ProcedureInfoDto params) throws SQLException {
    return this.procedureRepository.listInfoProcedures(params);
  }
}
