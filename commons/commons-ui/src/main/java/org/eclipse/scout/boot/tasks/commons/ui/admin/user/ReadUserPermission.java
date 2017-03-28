package org.eclipse.scout.boot.tasks.commons.ui.admin.user;

import java.security.BasicPermission;

public class ReadUserPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ReadUserPermission() {
    super(ReadUserPermission.class.getSimpleName());
  }
}
