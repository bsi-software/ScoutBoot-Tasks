package org.eclipse.scout.boot.tasks.commons.ui;

import javax.inject.Inject;

import org.eclipse.scout.boot.tasks.commons.model.User;
import org.eclipse.scout.boot.tasks.commons.model.service.UserService;
import org.eclipse.scout.boot.ui.scout.AbstractSpringBootClientSession;
import org.eclipse.scout.rt.client.IClientSession;
import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.platform.BEANS;

public class TasksClientSession extends AbstractSpringBootClientSession {

  private String userId = "";

  @Inject
  protected UserService userService;

  /**
   * @return The {@link IClientSession} which is associated with the current thread, or <code>null</code> if not found.
   */
  public static TasksClientSession get() {
    return ClientSessionProvider.currentSession(TasksClientSession.class);
  }

  @Override
  protected void execLoadSession() {
    initCurrentUser();
    setDesktop(BEANS.get(Desktop.class)); // lookup via BeanManager to support auto-wiring.
  }

  private void initCurrentUser() {
    if (getSubject() != null && !getSubject().getPrincipals().isEmpty()) {
      userId = getSubject().getPrincipals().iterator().next().getName();

      User user = userService.get(userId);
      if (user.getLocale() != null) {
        setLocale(user.getLocale());
      }
    }
  }

  @Override
  public String getUserId() {
    return userId;
  }
}
