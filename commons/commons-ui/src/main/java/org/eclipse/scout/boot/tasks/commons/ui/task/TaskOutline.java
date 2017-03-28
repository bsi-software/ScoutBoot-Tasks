package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.util.List;

import org.eclipse.scout.boot.tasks.commons.ui.FontAwesomeIcons;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.shared.TEXTS;

@Bean
public class TaskOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Tasks");
  }

  @Override
  protected String getConfiguredIconId() {
    return FontAwesomeIcons.fa_calendarCheckO;
  }

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    pageList.add(BEANS.get(InboxTablePage.class));
    pageList.add(BEANS.get(TodaysTaskTablePage.class));
    pageList.add(BEANS.get(MyTaskTablePage.class));
    pageList.add(BEANS.get(AllTasksTablePage.class));
  }
}
