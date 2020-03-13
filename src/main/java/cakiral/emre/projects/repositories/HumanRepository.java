package cakiral.emre.projects.repositories;


import cakiral.emre.projects.model.Human;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanRepository {
    List<Human> humans = new ArrayList<>();

    public Human addHuman(String name) {
        int id = humans.size() + 1;
        Human newHuman = new Human(
                id,
                name,
                "white",
                "brown",
                "male");

        newHuman.age = 16;
        humans.add(newHuman);
        return newHuman;
    }

    public Human getHumanById(int id){
        for (Human human: humans) {
            if(human.id == id) {
                return human;
            }
        }

        return null;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
