package org.eclipse.scout.boot.tasks.standalone.spring;

import javax.servlet.ServletContextListener;

import org.eclipse.scout.boot.tasks.standalone.spring.security.ScoutJaasApiIntegrationFilter;
import org.eclipse.scout.boot.ui.spring.ScoutBootWebappListener;
import org.eclipse.scout.rt.server.commons.HttpSessionMutex;
import org.eclipse.scout.rt.ui.html.UiServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class ScoutServletConfiguration {

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> scoutSpringWebappListener() {
		return new ServletListenerRegistrationBean<>(new ScoutBootWebappListener());
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionMutex> httpSessionMutex() {
		return new ServletListenerRegistrationBean<>(new HttpSessionMutex());
	}

	@Bean
	public ServletRegistrationBean dispatcherRegistration(WebApplicationContext webApplicationContext) {
		return new ServletRegistrationBean(new UiServlet(), WebMvcConfiguration.SCOUT_CONTEXT_PATH + "/*");
	}

	@Bean
	public FilterRegistrationBean scoutJaasApiIntegrationFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new ScoutJaasApiIntegrationFilter());
		registrationBean.setOrder(Integer.MAX_VALUE);
		return registrationBean;
	}

}
