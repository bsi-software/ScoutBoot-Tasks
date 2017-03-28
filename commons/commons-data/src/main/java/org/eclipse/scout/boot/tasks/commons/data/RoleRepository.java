package org.eclipse.scout.boot.tasks.commons.data;

import org.eclipse.scout.boot.tasks.commons.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
}
