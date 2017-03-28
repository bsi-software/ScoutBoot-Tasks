package org.eclipse.scout.boot.tasks.commons.ui.admin.user;

import java.security.BasicPermission;

public class CreateUserPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public CreateUserPermission() {
    super(CreateUserPermission.class.getSimpleName());
  }
}
