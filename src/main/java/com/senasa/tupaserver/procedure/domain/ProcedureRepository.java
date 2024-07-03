package com.senasa.tupaserver.procedure.domain;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureCalcTarifaDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureFindDto;
import com.senasa.tupaserver.procedure.domain.dtos.ProcedureInfoDto;

public interface ProcedureRepository {
  public List<ProcedureMapper> listProcedures(ProcedureFindDto params);

  public List<ProcedureInfoMapper> listInfoProcedures(ProcedureInfoDto params) throws SQLException;

  public List<ProcedureServiceMapper> listProcedureServices(ProcedureFindDto params);

  public double calcProcedureTarifa(ProcedureCalcTarifaDto params) throws SQLException;
}
