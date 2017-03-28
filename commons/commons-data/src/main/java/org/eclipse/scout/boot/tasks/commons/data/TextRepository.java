package org.eclipse.scout.boot.tasks.commons.data;

import org.eclipse.scout.boot.tasks.commons.data.entity.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<TextEntity, String> {

}
