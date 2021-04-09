package com.company;

import com.company.entity.UserEntity;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void TestJPAMethod(){
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setFirstName("Илья");
        user.setSecondName("Пупкин");
        user.setLogin("Vasya");
        user.setPassword("123456789");
        userService.createUser(user);
        userService.findAllByFirstName("Илья").forEach(it-> System.out.println(it));;
    }
}
