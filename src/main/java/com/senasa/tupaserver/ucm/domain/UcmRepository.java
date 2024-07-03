package com.senasa.tupaserver.ucm.domain;

import com.senasa.tupaserver.ucm.domain.dtos.UcmCreateDto;
import com.senasa.tupaserver.ucm.infrastructure.wsdl.RegistrarDocumentoResponse;

public interface UcmRepository {
  public RegistrarDocumentoResponse createUcm(UcmCreateDto params);
}
