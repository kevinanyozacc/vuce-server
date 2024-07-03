package com.senasa.tupaserver.documentType.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.senasa.tupaserver.documentType.application.DocumentTypeListService;
import com.senasa.tupaserver.documentType.domain.DocumentTypeEntity;
import com.senasa.tupaserver.documentType.infrastructure.repository.DocumentTypeJpaRepositoryImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/documentTypes")
public class DocumentTypeHttpController {
  @Autowired
  DocumentTypeJpaRepositoryImpl documentTypeRepository;

  @GetMapping(path = { "", "/" })
  public List<DocumentTypeEntity> listDocumentTypes() throws Exception {
    DocumentTypeListService service = new DocumentTypeListService(documentTypeRepository);
    return service.execute();
  }
}
