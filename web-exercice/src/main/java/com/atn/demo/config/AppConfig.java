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
