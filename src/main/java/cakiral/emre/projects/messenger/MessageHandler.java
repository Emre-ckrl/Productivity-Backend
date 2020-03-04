package cakiral.emre.projects.messenger;

import cakiral.emre.projects.Human;
import cakiral.emre.projects.Message;
import cakiral.emre.projects.repositories.HumanRepository;
import cakiral.emre.projects.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/send/{id}/{receiverId}")
    @ResponseBody
    public String sendMessage(@PathVariable("id") int id, @PathVariable("receiverId") int receiverId) {

        String message = "Hello, whats up?";

        Human sender = humanRepository.getHumanById(id);
        Human receiver = humanRepository.getHumanById(receiverId);
        messageRepository.addMessage(message, sender, receiver);


        return message;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/show/{id}")
    @ResponseBody
    public List<String> showMessages(@PathVariable("id") int id) {
        System.out.println("Got request");
        List<String> messages = new ArrayList<>();

        for (Message message : messageRepository.getMessages()) {
            if (message.sender.id == id || message.receiver.id == id) {
                messages.add(message.text);

            }
        }

        return messages;
    }
}
