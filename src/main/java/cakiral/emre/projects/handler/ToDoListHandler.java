package cakiral.emre.projects.handler;

import cakiral.emre.projects.model.Human;
import cakiral.emre.projects.handler.requestdata.ToDoRequestData;
import cakiral.emre.projects.repositories.HumanRepository;
import cakiral.emre.projects.model.ToDoList;
import cakiral.emre.projects.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping(path = "/todo/create", consumes = "application/json")
    public void addToDo(@RequestBody ToDoRequestData toDoRequestData, HttpServletResponse response) {

        String text = toDoRequestData.text;
        System.out.println(text);

        Human creator = humanRepository.getHumanById(toDoRequestData.id);
        toDoListRepository.addToDo(toDoRequestData.toDoListName, text, creator);

        response.setStatus(201);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/todolist/create", consumes = "application/json")
    public void createToDoList(@RequestBody ToDoRequestData toDoRequestData, HttpServletResponse response) {

        String name = toDoRequestData.text;
        System.out.println(name);

        Human creator = humanRepository.getHumanById(toDoRequestData.id);

        if (toDoListRepository
                .getToDoLists()
                .stream()
                .anyMatch(toDoList -> toDoList.name.equalsIgnoreCase(name))) {

            response.setStatus(HttpStatus.CONFLICT.value());
            return;
        }

        toDoListRepository.addToDoList(name, creator);
        response.setStatus(201);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/todo/show/{id}")
    @ResponseBody
    public List<String> showToDos(@PathVariable("id") int id) {
        List<String> toDoList = new ArrayList<>();
//
//        for (ToDo toDo : toDoListRepository.getToDos()) {
//            if (toDo.creator.id == id) {
//                toDoList.add(toDo.text);
//
//            }
//        }

        return toDoList;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/todos")
    @ResponseBody
    public List<ToDoList> getToDoLists() {
        return toDoListRepository.getToDoLists();
    }

}
