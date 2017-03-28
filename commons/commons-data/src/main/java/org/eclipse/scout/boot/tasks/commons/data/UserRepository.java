package org.eclipse.scout.boot.tasks.commons.data;

import org.eclipse.scout.boot.tasks.commons.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
