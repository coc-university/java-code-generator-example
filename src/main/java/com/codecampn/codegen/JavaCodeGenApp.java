package com.codecampn.codegen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaCodeGenApp {

    public static void main(String[] args) {
        SpringApplication.run(JavaCodeGenApp.class, args);
    }

    @Bean
    public CommandLineRunner startupRunner(Generator generator) {
        return args -> generator.run();
    }

}
