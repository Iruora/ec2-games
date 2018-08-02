package com.atn.demo.config;

import com.atn.commons.CommonsConfig;
import com.atn.commons.RepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ AppConfig.class })
@PropertySource(value = { "classpath:config.properties" }, ignoreResourceNotFound = false)
public class TestsConfig extends AppConfig{

}

