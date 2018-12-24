package com.atn.demo.config;

import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;



public class SpringMvcInitializer 
       extends AbstractAnnotationConfigDispatcherServletInitializer {


	 @Override
     protected Class< ? >[] getRootConfigClasses() {

	      return new Class< ? >[] { MvcResourcesConfig.class };
     }

     @Override
     protected Class< ? >[] getServletConfigClasses() {
             return new Class< ? >[] { MvcResourcesConfig.class };
     }

     @Override
     protected String[] getServletMappings() {
             return new String[] { "/" };
     }

     @Override
     protected javax.servlet.Filter[] getServletFilters() {
         //OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
         //openEntityManagerInViewFilter.setEntityManagerFactory(entityManagerFactory);
             return new javax.servlet.Filter[] {
                     //new OpenEntityManagerInViewFilter(),
                     new HiddenHttpMethodFilter() };
     }
	
}
