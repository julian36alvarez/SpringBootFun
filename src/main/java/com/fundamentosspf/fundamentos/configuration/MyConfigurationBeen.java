package com.fundamentosspf.fundamentos.configuration;

import com.fundamentosspf.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBeen {
    @Bean
    public MyBeen beenOperation(){
        return  new MyBeenImplement2();
    }

    @Bean
    public MyOperation beenOperationOperation(){
        return  new MyOperationImplement();
    }
    @Bean
    public MyBeenWithDependency beenOperationOperationithDependency(MyOperation myOperation){
        return  new MyBeenWithDependencyImplement(myOperation);
    }
}
