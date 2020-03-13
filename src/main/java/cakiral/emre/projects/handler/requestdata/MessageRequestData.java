package cakiral.emre.projects.handler.requestdata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequestData {
    public String text;
    public int receiverId;
    public int senderId;
}
