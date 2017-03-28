package org.eclipse.scout.boot.tasks.standalone.spring.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.scout.boot.tasks.commons.data.DocumentRepository;
import org.eclipse.scout.boot.tasks.commons.data.entity.DocumentEntity;
import org.eclipse.scout.boot.tasks.commons.model.Document;
import org.eclipse.scout.boot.tasks.commons.model.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultDocumentService implements DocumentService, MapperService<Document, DocumentEntity> {

  @Autowired
  private DocumentRepository documentRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Document> getAll() {
    return documentRepository.findAll()
        .stream()
        .map(document -> convertToModel(document, Document.class))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public boolean exists(UUID id) {
    return documentRepository.exists(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Document get(UUID id) {
    return documentRepository.exists(id) ? convertToModel(documentRepository.findOne(id), Document.class) : null;
  }

  @Override
  @Transactional
  public void save(Document document) {
    validate(document);
    documentRepository.save(convertToEntity(document, DocumentEntity.class));
  }

}
