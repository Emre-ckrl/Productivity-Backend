package cakiral.emre.projects.repositories;


import cakiral.emre.projects.model.Human;
import cakiral.emre.projects.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageRepository {
    List<Message> messages = new ArrayList<>();

    public void addMessage(String text, Human sender, Human receiver){
        Message newMessage = new Message(text, sender, receiver);
        messages.add(newMessage);
    }

    public List<Message> getMessages(){ return messages;
    }
}
