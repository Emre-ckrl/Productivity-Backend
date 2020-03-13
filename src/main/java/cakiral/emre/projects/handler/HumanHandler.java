package cakiral.emre.projects.handler;

import cakiral.emre.projects.model.Human;
import cakiral.emre.projects.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class HumanHandler {

    private final HumanRepository repository;

    @Autowired
    public HumanHandler(HumanRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/create")
    @ResponseBody
    public String createUser() {
        Human newHuman = repository.addHuman("Emre");

        return "user created: " + newHuman.name + " ID: " + newHuman.id;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    @ResponseBody
    public List<Human> getAllUser() {
        return repository.getHumans();
    }


    @GetMapping("/grow")
    @ResponseBody
    public List<Integer> growUser() {
        List<Integer> ages = new ArrayList<>();

        for (Human human : repository.getHumans()) {
            human.grow();
            ages.add(human.age);
        }

        return ages;
    }

    @GetMapping("/sun")
    @ResponseBody
    public List<String> tanUser() {
        List<String> skinColor = new ArrayList<>();
        for (Human human : repository.getHumans()) {
            human.sun();
            skinColor.add(human.skinColor);

        }

        return skinColor;
    }

}
