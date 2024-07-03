package com.senasa.tupaserver.ucm.application;

import javax.validation.Valid;
import com.senasa.tupaserver.ucm.domain.UcmRepository;
import com.senasa.tupaserver.ucm.domain.dtos.UcmCreateDto;
import com.senasa.tupaserver.ucm.infrastructure.wsdl.RegistrarDocumentoResponse;

public class UcmCreateService {
  public UcmCreateService(UcmRepository ucmRepository) {
    this.ucmRepository = ucmRepository;
  }

  UcmRepository ucmRepository;

  public String execute(@Valid UcmCreateDto params) throws Exception {
    RegistrarDocumentoResponse response = this.ucmRepository.createUcm(params);
    if (response.getReturn() == null) {
      throw new Exception("No se pudo guardar el archivo");
    }
    return response.getReturn();
  }
}
