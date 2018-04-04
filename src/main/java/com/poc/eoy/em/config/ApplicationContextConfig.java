/**
 * 
 */
package com.poc.eoy.em.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * This class provides configuration information to the application
 * 
 * @author lugupta
 */
@Configuration
@ComponentScan("com.poc.eoy.em.*")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "messages/validation" });

		return rb;
	}

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public DataSource getDataSource() {
		return new EmbeddedDatabaseBuilder().setName("employee_management_db").setType(EmbeddedDatabaseType.HSQL)
				.addScript("dbScripts/create_designations.sql").addScript("dbScripts/create_servicelines.sql")
				.addScript("dbScripts/create_roles.sql").addScript("dbScripts/create_employees.sql")
				.addScript("dbScripts/insert_script.sql").build();
	}

}