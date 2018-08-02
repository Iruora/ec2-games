package com.atn.demo.config;

import java.sql.Driver;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import com.atn.commons.RepositoryConfig;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.atn.commons.CommonsConfig;

@Configuration
@Import({ RepositoryConfig.class,CommonsConfig.class })
@PropertySource(value = { "classpath:config.properties" }, ignoreResourceNotFound = false)
public /*abstract*/ class AppConfig extends RepositoryConfig {
	/*@Bean(name = "dataSource")
	public DataSource dataSource() {
		Driver driver = new org.h2.Driver();
		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource(
				driver,
				"jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=Oracle;TRACE_LEVEL_SYSTEM_OUT=2");
		DataSource dataSource = new LazyConnectionDataSourceProxy(
				simpleDriverDataSource);
		return dataSource;
	}*/
	/*@Bean
	public DataSourceInitializer dataSourceInitializer() {
	    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
	    resourceDatabasePopulator.addScript(new ClassPathResource("metadata/schema.sql"));
	    resourceDatabasePopulator.addScript(new ClassPathResource("metadata/data.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }*/
	@Bean
	 public DataSource getDataSource(){
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost/arouri");
	  ds.setUsername("root");
	  ds.setPassword("");
	  
	  return ds;
	 }

}
