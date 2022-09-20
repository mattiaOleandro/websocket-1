package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendMessageToBroadcast(@RequestBody MessageDTO messageDTO){

        try {
            simpMessagingTemplate.convertAndSend("/topic/messages", messageDTO);
            return  ResponseEntity.status(HttpStatus.OK).body("Message sent");
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}