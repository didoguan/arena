package com.deepspc.arena.config;

import com.deepspc.arena.config.properties.AppNameProperties;
import com.deepspc.arena.config.properties.DruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.application")
    public AppNameProperties appNameProperties() {
        return new AppNameProperties();
    }
}
