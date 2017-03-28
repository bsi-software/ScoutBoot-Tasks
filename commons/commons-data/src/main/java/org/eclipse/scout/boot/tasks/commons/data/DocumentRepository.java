package org.eclipse.scout.boot.tasks.commons.data;

import java.util.UUID;

import org.eclipse.scout.boot.tasks.commons.data.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
}
