package cakiral.emre.projects.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ToDoList {
    public String name;
    public List<ToDo> toDos = new ArrayList<>();

    public ToDoList(String name) {
        this.name = name;
    }
}
