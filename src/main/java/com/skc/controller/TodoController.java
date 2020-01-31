package com.skc.controller;

import com.skc.entity.SpringBootTodoApplication;
import com.skc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired TodoRepository todoRepository;

    @GetMapping
    public String index(){
        return  "index";
    }

    @GetMapping("/todos")
    public String todos(Model model){
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @PostMapping("/todoNew")
    public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
        SpringBootTodoApplication springBootTodoApplication = new SpringBootTodoApplication();
        springBootTodoApplication.setTodoItem(todoItem);
        springBootTodoApplication.setCompleted(status);
        todoRepository.save(springBootTodoApplication);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoDelete/{id}")
    public String delete(@PathVariable long id, Model model){
        todoRepository.deleteById(id);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoUpdate/{id}")
    public String update(@PathVariable long id, Model model) {
        SpringBootTodoApplication springBootTodoApplication = todoRepository.findById(id).get();
        if("Yes".equals(springBootTodoApplication.getCompleted())) {
            springBootTodoApplication.setCompleted("No");
        }
        else {
            springBootTodoApplication.setCompleted("Yes");
        }
        todoRepository.save(springBootTodoApplication);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }
}
