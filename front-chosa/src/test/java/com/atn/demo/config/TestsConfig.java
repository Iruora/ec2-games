package com.atn.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan({ "com.atn.demo.mvc.module.*",
	"com.atn.commons.persistence",
	"com.atn.commons.service",
	"com.atn.commons.email",
	"com.atn.commons.log"})
@PropertySource("classpath:/config.properties")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TestsConfig  extends AppConfig {
	/**
	 * 
	 */
	interface DataScript {
		String SCRIPT_STRUCTURE_SQL = "classpath:sql/schema.sql";
		String SCRIPT_DATA_SQL = "classpath:sql/data.sql";
	}

	/**
	 * 
	 */
	interface PersistenceUnitParam {
		String NAME = "pu";
		String XML_PERSISTENCE_LOCATION = "classpath:META-INF/persistence.xml";
	}

	/**
	 * 
	 */
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		final EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.HSQL)
				.addScript(DataScript.SCRIPT_STRUCTURE_SQL).addScript(DataScript.SCRIPT_DATA_SQL).build();
		return embeddedDatabase;
	}

	/**
	 * 
	 */
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setPersistenceXmlLocation(PersistenceUnitParam.XML_PERSISTENCE_LOCATION);
		localContainerEntityManagerFactoryBean.setPersistenceUnitName(PersistenceUnitParam.NAME);
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		return localContainerEntityManagerFactoryBean;
	}

	/**
	 * 
	 */
	@Bean(name = "jpaVendorAdapter")
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
		return jpaVendorAdapter;
	}
	
//	@Bean
//	 public PlatformTransactionManager  hibernateTransactionManager(){
//		final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//	  return jpaTransactionManager;
//	 }
	
	@Bean(name = "multipartResolver")
	 public CommonsMultipartResolver createMultipartResolver() {
	  CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	  resolver.setDefaultEncoding("utf-8");
	  resolver.setMaxUploadSize(3000000);
	  return resolver;
	 }
}

