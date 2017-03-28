package org.eclipse.scout.boot.tasks.commons.model.service;

import java.util.List;
import java.util.UUID;

import org.eclipse.scout.boot.tasks.commons.model.Task;

public interface TaskService extends ValidatorService<Task> {

  List<Task> getAll();

  List<Task> getToday(String userId);

  List<Task> getOwn(String userId);

  List<Task> getInbox(String userId);

  boolean exists(UUID taskId);

  Task get(UUID taskId);

  void save(Task task);

}
