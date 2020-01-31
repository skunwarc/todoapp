package com.skc;

import com.skc.entity.Todo;
import com.skc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class SpringBootTodoApplication implements CommandLineRunner{

    @Autowired
    public TodoRepository todoRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootTodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Collection<Todo> todos = Arrays.asList(
                new Todo("Learn Spring", "Yes"),
                new Todo("Learn Driving", "No"),
                new Todo("Go for a Walk", "No"),
                new Todo("Cook Dinner", "Yes"));
                todos.forEach(todoRepository::save);

    }
}
