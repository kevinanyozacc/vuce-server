package com.senasa.tupaserver.expediente.application;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaMapper;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaRepository;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;

public class ExpedienteCuarentenaListService {
  public ExpedienteCuarentenaListService(
      ExpedienteRepository expedienteRepository,
      CuarentenaRepository cuarentenaRepository) {
    this.expedienteRepository = expedienteRepository;
    this.cuarentenaRepository = cuarentenaRepository;
  }

  ExpedienteRepository expedienteRepository;
  CuarentenaRepository cuarentenaRepository;

  public List<CuarentenaMapper> execute(ExpedienteFindDto params) throws SQLException, ErrorNotFoundException {
    ExpedienteMapper expediente = this.expedienteRepository.findExpediente(params);
    if (expediente == null) {
      throw new ErrorNotFoundException("El expediente no existe");
    }
    // listar cuarentenas
    CuarentenaListDto request = new CuarentenaListDto();
    request.setExpedienteId(expediente.getId());
    return this.cuarentenaRepository.listCuarentenas(request);
  }
}
