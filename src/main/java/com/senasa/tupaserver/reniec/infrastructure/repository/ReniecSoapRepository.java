package com.senasa.tupaserver.reniec.infrastructure.repository;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.senasa.tupaserver.reniec.domain.ReniecRepository;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosPorRUC;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosPorRUCResponse;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosReniec;
import com.senasa.tupaserver.reniec.infrastructure.wsdl.ObtenerDatosReniecResponse;

public class ReniecSoapRepository extends WebServiceGatewaySupport implements ReniecRepository {

  @Override
  public ObtenerDatosPorRUCResponse findPersonByRuc(String ruc) {
    ObtenerDatosPorRUC request = new ObtenerDatosPorRUC();
    request.setArg0(ruc);
    ObtenerDatosPorRUCResponse response = (ObtenerDatosPorRUCResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
    return response;
  }

  @Override
  public ObtenerDatosReniecResponse findPersonByDni(String dni) {
    ObtenerDatosReniec request = new ObtenerDatosReniec();
    request.setArg0(dni);
    ObtenerDatosReniecResponse response = (ObtenerDatosReniecResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
    return response;
  }
}
