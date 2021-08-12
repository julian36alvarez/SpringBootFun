package com.fundamentosspf.fundamentos;

import com.fundamentosspf.fundamentos.bean.MyBeanWithPropertis;
import com.fundamentosspf.fundamentos.bean.MyBeen;
import com.fundamentosspf.fundamentos.bean.MyBeenWithDependency;
import com.fundamentosspf.fundamentos.component.ComponentDependency;
import com.fundamentosspf.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
    private MyBeen myBeen;
    private MyBeenWithDependency myBeenWithDependency;
    private MyBeanWithPropertis myBeanWithPropertis;
    private UserPojo userPojo;
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeen myBeen, MyBeenWithDependency myBeenWithDependency, MyBeanWithPropertis myBeanWithPropertis, UserPojo userPojo) {
        this.componentDependency = componentDependency;
        this.myBeen = myBeen;
        this.myBeenWithDependency = myBeenWithDependency;
        this.myBeanWithPropertis = myBeanWithPropertis;
        this.userPojo = userPojo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBeen.print();
        myBeenWithDependency.printWithDependency();
        System.out.println(myBeanWithPropertis.function());
        System.out.println(userPojo.getEmail() +" "+userPojo.getPassword());
    }
}
