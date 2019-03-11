package com.training.springcore.config;

import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
@Profile("prod")
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-prod.properties")
public class BigCorpApplicationProdConfig{

    @Autowired
    private Environment environment;

    @Bean
    public ApplicationInfo applicationInfo(){
        String name = environment.getRequiredProperty("bigcorp.name");
        Integer version = environment.getRequiredProperty("bigcorp.version",Integer.class);
        Set<String> emails = environment.getRequiredProperty("bigcorp.emails", Set.class);
        return new ApplicationInfo(name, version, emails);
    }
}
