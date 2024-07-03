package com.senasa.tupaserver.documentType.infrastructure.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.documentType.domain.DocumentTypeEntity;
import com.senasa.tupaserver.documentType.domain.DocumentTypeRepository;
import com.senasa.tupaserver.documentType.domain.dtos.DocumentTypeFindDto;

@Service
public class DocumentTypeJpaRepositoryImpl implements DocumentTypeRepository {
  @Autowired
  DocumentTypeJpaRepository repository;

  @Override
  public List<DocumentTypeEntity> listDocumentTypes() {
    return this.repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public DocumentTypeEntity findDocumentTypes(DocumentTypeFindDto params) {
    if (params.getId() != null) {
      return this.repository.findById(params.getId()).orElse(null);
    } else {
      return null;
    }
  }
}
