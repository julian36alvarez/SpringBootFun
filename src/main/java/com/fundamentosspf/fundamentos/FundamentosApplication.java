package com.fundamentosspf.fundamentos;

import com.fundamentosspf.fundamentos.bean.MyBeanWithPropertis;
import com.fundamentosspf.fundamentos.bean.MyBeen;
import com.fundamentosspf.fundamentos.bean.MyBeenWithDependency;
import com.fundamentosspf.fundamentos.component.ComponentDependency;
import com.fundamentosspf.fundamentos.entity.User;
import com.fundamentosspf.fundamentos.pojo.UserPojo;
import com.fundamentosspf.fundamentos.repository.UserRepository;
import com.fundamentosspf.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
    private MyBeen myBeen;
    private MyBeenWithDependency myBeenWithDependency;
    private MyBeanWithPropertis myBeanWithPropertis;
    private UserPojo userPojo;
    private UserRepository userRepository;
    private UserService userService;

    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeen myBeen, MyBeenWithDependency myBeenWithDependency, MyBeanWithPropertis myBeanWithPropertis, UserPojo userPojo, UserRepository userRepository, UserService userService) {
        this.componentDependency = componentDependency;
        this.myBeen = myBeen;
        this.myBeenWithDependency = myBeenWithDependency;
        this.myBeanWithPropertis = myBeanWithPropertis;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) {
    //ejemplosAnteriores();
        saveUserInDataBase();
        getInformationJpqlFromUser();
        saveWithErrorTransactional();
    }
    private void getInformationJpqlFromUser(){
       LOGGER.info("Usuario con el metodo fingByUserEmail" + userRepository
               .findByUserEmail("julian@julianes.com")
               .orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
       userRepository.findAndSort("user", Sort.by("id").descending())
               .stream()
               .forEach(user -> LOGGER.info("User with method sort " +user));
       userRepository.findByName("user")
               .stream()
               .forEach(user->LOGGER.info("user with query method: "+user));

        LOGGER.info("BUSQUEDA POR EMAIL DOS PARAMETROS" +userRepository.findByNameOrEmail(null, "julian@julianes.com")
                .orElseThrow(()-> new RuntimeException("Error")));
        LOGGER.info("EL USUARIO APARTIR DE" + userRepository.getAllByBirthDayAndEmail(LocalDate.of(2021,03,10),"leidy@leidys.com")
                .orElseThrow(()->new RuntimeException("No se encontro nada")));

    }


    private  void  saveUserInDataBase(){
        User user1 = new User("Julian","julian@julianes.com", LocalDate.of(2021,03,10));
        User user2 = new User("Leidys","leidy@leidys.com", LocalDate.of(2021,03,10));
        User user3 = new User("user3","user3@leidys.com", LocalDate.of(2021,03,10));
        User user4 = new User("user4","user4@leidys.com", LocalDate.of(2021,03,10));
        User user5 = new User("user5","user5@leidys.com", LocalDate.of(2021,03,10));
        User user6 = new User("user6","user6@leidys.com", LocalDate.of(2021,03,10));
        User user7 = new User("user7","user7@leidys.com", LocalDate.of(2021,03,10));
        User user8 = new User("user8","user8@leidys.com", LocalDate.of(2021,03,10));
        User user9 = new User("user9","user9@leidys.com", LocalDate.of(2021,03,10));
        User user0 = new User("user0","user10@leidys.com", LocalDate.of(2021,03,10));
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5, user6, user7, user8,user9,user0);
        list.stream().forEach(s -> userRepository.save(s));
    }

    private void ejemplosAnteriores(){
        componentDependency.saludar();
        myBeen.print();
        myBeenWithDependency.printWithDependency();
        System.out.println(myBeanWithPropertis.function());
        System.out.println(userPojo.getEmail() +" "+userPojo.getPassword());
        try {
            int value =10/1;
            LOGGER.debug("Mi Valor: "+value);
        } catch (Exception e){
            LOGGER.error("Esto es un error");
        }
    }

    private void saveWithErrorTransactional(){
        User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
        User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
        User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
        List<User> users = Arrays.asList( test1, test2, test3, test4 );
        try {
            userService.saveTransaccional(users);
        }catch (Exception e){
            LOGGER.error("Error "+ e);
        }


        userService.getAllUsers().stream().forEach(user->LOGGER.info("Este es el usuario dentro del metodo transaccional" + user));
    }
}
