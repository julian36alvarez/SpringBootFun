package com.fundamentosspf.fundamentos.configuration;

import com.fundamentosspf.fundamentos.caseuse.GetUser;
import com.fundamentosspf.fundamentos.caseuse.GetUserImplement;
import com.fundamentosspf.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
