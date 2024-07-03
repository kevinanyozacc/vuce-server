package com.senasa.tupaserver.documentType.domain;

import java.util.List;
import com.senasa.tupaserver.documentType.domain.dtos.DocumentTypeFindDto;

public interface DocumentTypeRepository {
  List<DocumentTypeEntity> listDocumentTypes();

  DocumentTypeEntity findDocumentTypes(DocumentTypeFindDto params);
}
