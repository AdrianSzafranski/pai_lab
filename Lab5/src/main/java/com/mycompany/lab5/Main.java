
package com.mycompany.lab5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan({"com.mycompany.lab5.controllers"})
@EnableJpaRepositories({"com.mycompany.lab5.repositories"})

public class Main {
    public static void main(String[] args) {
     SpringApplication.run(Main.class, args);
    }
    
}