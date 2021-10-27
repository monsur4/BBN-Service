package com.mon.bbn.exceptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class BbnServiceSimpleMappingException {

    @Bean
    public SimpleMappingExceptionResolver getMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mapping = new Properties();
        mapping.put("java.lang.Exception", "errorPage");
        resolver.setExceptionMappings(mapping);
        return resolver;
    }
}
