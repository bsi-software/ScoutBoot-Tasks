package org.eclipse.scout.boot.tasks.commons.ui.admin.text;

import java.security.BasicPermission;

public class CreateTranslationPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public CreateTranslationPermission() {
    super(CreateTranslationPermission.class.getSimpleName());
  }
}
