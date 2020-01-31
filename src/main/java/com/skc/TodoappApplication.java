package com.skc;

import com.skc.entity.SpringBootTodoApplication;
import com.skc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@ComponentScan
@Configuration
public class TodoappApplication implements CommandLineRunner{

    @Autowired
    public TodoRepository todoRepository;

    public static void main(String[] args) {

        SpringApplication.run(TodoappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Collection<SpringBootTodoApplication> springBootTodoApplications = Arrays.asList(new SpringBootTodoApplication("Learn Spring", "Yes"), new SpringBootTodoApplication("Learn Driving", "No"), new SpringBootTodoApplication("Go for a Walk", "No"), new SpringBootTodoApplication("Cook Dinner", "Yes"));
        springBootTodoApplications.forEach(todoRepository::save);

    }
}
