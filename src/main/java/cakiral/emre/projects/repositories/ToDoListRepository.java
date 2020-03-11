package cakiral.emre.projects.repositories;


import cakiral.emre.projects.Human;
import cakiral.emre.projects.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListRepository {
    List<ToDoList> toDoLists = new ArrayList<>();

    public void addToDoList(String text, Human sender){
        ToDoList newToDoList = new ToDoList(text);
        toDoLists.add(newToDoList);
    }

    public void addToDo(String todoListName, String text, Human sender){
        ToDo newToDo = new ToDo(text, sender);

        List<ToDoList> result = toDoLists.stream()
                .filter(list -> list.name.equalsIgnoreCase(todoListName))
                .collect(Collectors.toList());

        if(result.isEmpty() || result.get(0) == null){
            return;
        }

        result.get(0).toDos.add(newToDo);
    }

    public List<ToDoList> getToDoLists() {return toDoLists;
    }
}
