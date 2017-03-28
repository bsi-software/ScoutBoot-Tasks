package org.eclipse.scout.boot.tasks.commons.data;

import java.util.List;
import java.util.UUID;

import org.eclipse.scout.boot.tasks.commons.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

  List<TaskEntity> findByResponsible(String userId);

}
