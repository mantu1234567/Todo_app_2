package com.geekster.Todo_App.service;

import com.geekster.Todo_App.entity.Todo;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {

    private List<Todo> myTodos;


    public TodoService() {
        myTodos = new ArrayList<>();
    }

    public List<Todo> getAll() {
        return myTodos;
    }

    public String addAll(Todo todo) {
        myTodos.add(todo);
        return "add todo";
    }

    public List<Todo> doneTodo() {
        List<Todo> doneTodos= new ArrayList<>();
        for(Todo myTodo: myTodos){
            if(myTodo.isTodoStatus()){
                doneTodos.add(myTodo);
            }

        }
        return doneTodos;
    }
    public List<Todo> notDone() {
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo:myTodos){
            if(!myTodo.isTodoStatus()) {
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }

    public String upDate(Integer todoId,boolean status) {
        for(Todo myTodo:myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodo.setTodoStatus(status);
                return "todo update for todoId:"+ todoId;
            }
        }
        return "todo not found todoId:"+todoId;
    }
}
