package cakiral.emre.projects;

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
