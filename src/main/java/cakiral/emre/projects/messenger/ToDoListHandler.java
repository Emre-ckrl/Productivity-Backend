package cakiral.emre.projects.messenger;

import cakiral.emre.projects.Human;
import cakiral.emre.projects.Message;
import cakiral.emre.projects.ToDoList;
import cakiral.emre.projects.ToDoRequestData;
import cakiral.emre.projects.repositories.HumanRepository;
import cakiral.emre.projects.repositories.MessageRepository;
import cakiral.emre.projects.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
@Controller
public class ToDoListHandler {

    private final HumanRepository humanRepository;
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListHandler(HumanRepository humanRepository, ToDoListRepository toDoListRepository) {
        this.humanRepository = humanRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/todo/create", consumes = "application/json")
    public void createToDo(@RequestBody ToDoRequestData toDoRequestData, HttpServletResponse response) {

        String text = toDoRequestData.text;
        System.out.println(text);

        Human creator = humanRepository.getHumanById(toDoRequestData.id);
        toDoListRepository.addToDoList(text, creator);
        response.setStatus(201);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/todo/show/{id}")
    @ResponseBody
    public List<String> showToDos(@PathVariable("id") int id) {
        System.out.println("Got request");
        List<String> toDoList = new ArrayList<>();

        for (ToDoList toDo : toDoListRepository.getToDoLists()) {
            if (toDo.creator.id == id) {
                toDoList.add(toDo.text);

            }
        }

        return toDoList;
    }
}
