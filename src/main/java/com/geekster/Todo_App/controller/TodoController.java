package com.geekster.Todo_App.controller;

import ch.qos.logback.core.BasicStatusManager;
import com.geekster.Todo_App.entity.Todo;
import com.geekster.Todo_App.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping("todo")
    public List<Todo> getAll(){
        return todoService.getAll();
    }
    @GetMapping("done/todo")
    public List<Todo> doneTodo(){
        return todoService.doneTodo();
    }

    @GetMapping("not/done")
    public List<Todo> notDone(){
        return todoService.notDone();
    }


    @PostMapping("todos")
    public String addAll(@RequestBody Todo todo){

        return todoService.addAll(todo);
    }
    @PutMapping("todo/{todoId}/{status}")
     public String updateTodo(@PathVariable Integer todoId,@PathVariable boolean status){
        return todoService.upDate(todoId,status);
    }

}
