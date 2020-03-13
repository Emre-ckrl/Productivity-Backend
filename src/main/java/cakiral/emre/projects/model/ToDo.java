package cakiral.emre.projects.model;

import cakiral.emre.projects.model.Human;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDo {
    public String text;
    public Human creator;
    public boolean condition = false;

    public ToDo(String text, Human creator) {
        this.text = text;
        this.creator = creator;
    }

}
