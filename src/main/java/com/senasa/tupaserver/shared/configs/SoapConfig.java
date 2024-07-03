package com.senasa.tupaserver.shared.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.senasa.tupaserver.reniec.infrastructure.repository.ReniecSoapRepository;
import com.senasa.tupaserver.ucm.infrastructure.repository.UcmSoapRepository;

@Configuration
public class SoapConfig {

  @Value("${reniec.service.soap-url}")
  private String reniecUrl;

  @Value("${ucm.service.soap-url}")
  private String ucmUrl;

  @Bean
  Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan(
        "com.senasa.tupaserver.reniec.infrastructure.wsdl",
        "com.senasa.tupaserver.ucm.infrastructure.wsdl");
    return marshaller;
  }

  @Bean
  ReniecSoapRepository getReniecSoapRepository(Jaxb2Marshaller marshaller) {
    ReniecSoapRepository repository = new ReniecSoapRepository();
    repository.setDefaultUri(this.reniecUrl);
    repository.setMarshaller(marshaller);
    repository.setUnmarshaller(marshaller);
    return repository;
  }

  @Bean
  UcmSoapRepository getUcmSoapRepository(Jaxb2Marshaller marshaller) {
    UcmSoapRepository repository = new UcmSoapRepository();
    repository.setDefaultUri(this.ucmUrl);
    repository.setMarshaller(marshaller);
    repository.setUnmarshaller(marshaller);
    return repository;
  }
}
