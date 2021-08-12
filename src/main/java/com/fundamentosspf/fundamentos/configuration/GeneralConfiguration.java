package com.fundamentosspf.fundamentos.configuration;

import com.fundamentosspf.fundamentos.bean.MyBeanWithPropertis;
import com.fundamentosspf.fundamentos.bean.MyBeanWithPropertisImlpement;
import com.fundamentosspf.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithPropertis function(){
        return new MyBeanWithPropertisImlpement(name, apellido);
    }

}
