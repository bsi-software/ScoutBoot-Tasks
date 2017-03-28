package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.security.BasicPermission;

public class ViewAllTasksPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ViewAllTasksPermission() {
    super(ViewAllTasksPermission.class.getSimpleName());
  }
}
