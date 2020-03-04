package cakiral.emre.projects;

import cakiral.emre.projects.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class EmreHandler {

    private final HumanRepository repository;

    @Autowired
    public EmreHandler(HumanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello/emre")
    @ResponseBody
    public String halloE() {
        return "hello emre!";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createUser() {
       Human newHuman =  repository.addHuman("Emre");

        return "user created: " + newHuman.name + " ID: " + newHuman.id;
    }


    @GetMapping("/all")
    @ResponseBody
    public List<String> getAllUser() {
        List<String> names = new ArrayList<>();

        for (Human human: repository.getHumans() ) {
            names.add(human.name);
        }

        return names;
    }



    @GetMapping("/grow")
    @ResponseBody
    public List<Integer> growUser() {
        List<Integer> ages = new ArrayList<>();

        for (Human human: repository.getHumans() ) {
            human.grow();
            ages.add(human.age);
        }

        return ages;
    }

    @GetMapping("/official/website")
    @ResponseBody
    public String welcomeUser() {

        return "official website";
    }

    @GetMapping("/sun")
    @ResponseBody
    public List<String> tanUser() {
        List<String> skinColor = new ArrayList<>();
        for (Human human: repository.getHumans() ) {
            human.sun();
            skinColor.add(human.skinColor);

        }

        return skinColor;
    }


}
