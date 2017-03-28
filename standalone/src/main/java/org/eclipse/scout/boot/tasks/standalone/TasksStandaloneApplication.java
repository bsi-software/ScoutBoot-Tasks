package org.eclipse.scout.boot.tasks.standalone;

import org.eclipse.scout.boot.tasks.standalone.spring.ScoutServletConfiguration;
import org.eclipse.scout.boot.tasks.standalone.spring.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot start class
 */
@SpringBootApplication
@Import({ScoutServletConfiguration.class, WebMvcConfiguration.class})
@ComponentScan(basePackages = "org.eclipse.scout.boot")
@EnableJpaRepositories("org.eclipse.scout.boot.tasks.commons.data")
@EntityScan("org.eclipse.scout.boot.tasks.commons.data")
public class TasksStandaloneApplication {

  public static void main(final String[] args) {
    applySystemProperties();
    SpringApplication.run(TasksStandaloneApplication.class, args);
  }

  /**
   * Apply system properties that have to bet set before the boot application starts
   */
  protected static void applySystemProperties() {
    System.setProperty("spring.devtools.restart.enabled", "true");
  }

}
