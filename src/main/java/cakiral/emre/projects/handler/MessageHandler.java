package cakiral.emre.projects.handler;

import cakiral.emre.projects.model.Human;
import cakiral.emre.projects.model.Message;
import cakiral.emre.projects.handler.requestdata.MessageRequestData;
import cakiral.emre.projects.repositories.HumanRepository;
import cakiral.emre.projects.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
@Controller
public class MessageHandler {

    private final HumanRepository humanRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageHandler(HumanRepository humanRepository, MessageRepository messageRepository) {
        this.humanRepository = humanRepository;
        this.messageRepository = messageRepository;
    }

    @CrossOrigin (origins = "http://localhost:4200")
    @PostMapping(path="/send", consumes = "application/json")
    public void sendMessage(@RequestBody MessageRequestData messageRequestData, HttpServletResponse response) {
        String message = messageRequestData.text;
        System.out.println("Sender " + messageRequestData.senderId);
        System.out.println("Receiver " + messageRequestData.receiverId);

        Human sender = humanRepository.getHumanById(messageRequestData.senderId);
        Human receiver = humanRepository.getHumanById(messageRequestData.receiverId);
        messageRepository.addMessage(message, sender, receiver);
        response.setStatus(HttpStatus.CREATED.value());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/show/{id}")
    @ResponseBody
    public List<Message> showMessages(@PathVariable("id") int id) {
        System.out.println("Got request");

        return messageRepository.getMessages()
                .stream()
                .filter(message -> (message.sender.id == id
                        || message.receiver.id == id))
                .collect(Collectors.toList());
    }
}
