package com.example.Employee_PayRoll.configuration;

import com.example.Employee_PayRoll.DB;
import com.example.Employee_PayRoll.DevDB;
import com.example.Employee_PayRoll.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project1.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project1.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB();
    }

    // ✅ Fallback bean if neither condition is met (e.g., property is missing)
    @Bean
    @ConditionalOnMissingBean(DB.class)
    public DB getDefaultDBBean() {
        return new DevDB(); // Or use ProdDB() if you prefer that as default
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}

