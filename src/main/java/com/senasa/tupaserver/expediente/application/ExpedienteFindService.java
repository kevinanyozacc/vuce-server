package com.senasa.tupaserver.expediente.application;

import java.sql.SQLException;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;

public class ExpedienteFindService {
  public ExpedienteFindService(ExpedienteRepository expedienteRepository) {
    this.expedienteRepository = expedienteRepository;
  }

  ExpedienteRepository expedienteRepository;

  public ExpedienteMapper execute(ExpedienteFindDto params) throws SQLException, ErrorNotFoundException {
    ExpedienteMapper expediente = this.expedienteRepository.findExpediente(params);
    if (expediente == null) {
      throw new ErrorNotFoundException("No se encontró el expediente");
    } else {
      return expediente;
    }
  }
}
