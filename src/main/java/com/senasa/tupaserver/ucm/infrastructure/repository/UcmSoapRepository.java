package com.senasa.tupaserver.ucm.infrastructure.repository;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.senasa.tupaserver.ucm.domain.UcmRepository;
import com.senasa.tupaserver.ucm.domain.dtos.UcmCreateDto;
import com.senasa.tupaserver.ucm.infrastructure.wsdl.RegistrarDocumento;
import com.senasa.tupaserver.ucm.infrastructure.wsdl.RegistrarDocumentoResponse;

public class UcmSoapRepository extends WebServiceGatewaySupport implements UcmRepository {

  @Override
  public RegistrarDocumentoResponse createUcm(UcmCreateDto params) {
    RegistrarDocumento request = new RegistrarDocumento();
    request.setArg0("");
    request.setArg1(params.getTitle());
    request.setArg2(params.getAutor());
    request.setArg3("OTRS");
    request.setArg4("interno");
    request.setArg5("OTRO");
    request.setArg6(params.getFilename());
    request.setArg7(params.getBuffer());
    RegistrarDocumentoResponse response = (RegistrarDocumentoResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
    return response;
  }
}
