package com.senasa.tupaserver.documentType.application;

import java.util.List;
import com.senasa.tupaserver.documentType.domain.DocumentTypeEntity;
import com.senasa.tupaserver.documentType.domain.DocumentTypeRepository;

public class DocumentTypeListService {
  private DocumentTypeRepository documentTypeRepository;

  public DocumentTypeListService(DocumentTypeRepository documentTypeRepository) {
    this.documentTypeRepository = documentTypeRepository;
  }

  public List<DocumentTypeEntity> execute() throws Exception {
    return this.documentTypeRepository.listDocumentTypes();
  }
}
