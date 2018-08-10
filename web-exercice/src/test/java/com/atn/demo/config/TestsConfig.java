package com.atn.demo.config;

import com.atn.commons.CommonsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CommonsConfig.class })
public class TestsConfig {

}

