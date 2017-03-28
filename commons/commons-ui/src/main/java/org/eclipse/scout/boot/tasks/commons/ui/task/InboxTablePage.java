package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.scout.boot.tasks.commons.model.Task;
import org.eclipse.scout.boot.tasks.commons.model.service.TaskService;
import org.eclipse.scout.rt.shared.TEXTS;

public class InboxTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public InboxTablePage() {
    getTable().getResponsibleColumn().setDisplayable(false);
    getTable().getAcceptedColumn().setDisplayable(false);
    getTable().getDoneColumn().setDisplayable(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("InboxTablePage");
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getInbox(getUserId());
  }

  @Override
  protected void execPageActivated() {
    reloadPage();
  }
}
