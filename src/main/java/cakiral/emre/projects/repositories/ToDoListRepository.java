package cakiral.emre.projects.repositories;


import cakiral.emre.projects.Human;
import cakiral.emre.projects.Message;
import cakiral.emre.projects.ToDoList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListRepository {
    List<ToDoList> toDoLists = new ArrayList<>();

    public void addToDoList(String text, Human sender){
        ToDoList newToDoList = new ToDoList (text, sender);
        toDoLists.add(newToDoList);
    }

    public List<ToDoList> getToDoLists() { return toDoLists;
    }
}
