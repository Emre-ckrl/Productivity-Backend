package cakiral.emre.projects;

public class Message {
    public String text;
    public Human sender;
    public Human receiver;

    public Message(String text, Human sender, Human receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

}
