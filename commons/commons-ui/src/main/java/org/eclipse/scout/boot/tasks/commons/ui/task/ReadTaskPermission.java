package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.security.BasicPermission;

public class ReadTaskPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ReadTaskPermission() {
    super(ReadTaskPermission.class.getSimpleName());
  }
}
