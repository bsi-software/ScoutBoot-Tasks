package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.scout.boot.tasks.commons.model.Task;
import org.eclipse.scout.boot.tasks.commons.model.service.TaskService;
import org.eclipse.scout.rt.shared.TEXTS;

public class AllTasksTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public AllTasksTablePage() {
    getTable().getReminderColumn().setVisible(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("AllTasks");
  }

  @Override
  protected void execInitPage() {
    setVisiblePermission(new ViewAllTasksPermission());
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getAll();
  }

  @Override
  protected void execPageActivated() {
    // NOOP
  }

}
