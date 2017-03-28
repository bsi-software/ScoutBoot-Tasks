package org.eclipse.scout.boot.tasks.commons.ui;

import org.eclipse.scout.rt.shared.services.common.text.AbstractDynamicNlsTextProviderService;

public class TextProviderService extends AbstractDynamicNlsTextProviderService {

  @Override
  public String getDynamicNlsBaseName() {
    return "org.eclipse.scout.boot.tasks.commons.ui.nls.Texts";
  }
}
