package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.security.BasicPermission;

public class CreateTaskPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public CreateTaskPermission() {
    super(CreateTaskPermission.class.getSimpleName());
  }
}
