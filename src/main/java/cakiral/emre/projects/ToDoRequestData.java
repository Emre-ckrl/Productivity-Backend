package cakiral.emre.projects;

import cakiral.emre.projects.repositories.ToDoList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoRequestData {
    public String text;
    public int id;
    public String toDoListName;

}
