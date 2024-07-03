package com.senasa.tupaserver.reniec.domain;

import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosPorRUCResponse;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosReniecResponse;

public interface ReniecRepository {
  public ObtenerDatosPorRUCResponse findPersonByRuc(String ruc);

  public ObtenerDatosReniecResponse findPersonByDni(String dni);
}
