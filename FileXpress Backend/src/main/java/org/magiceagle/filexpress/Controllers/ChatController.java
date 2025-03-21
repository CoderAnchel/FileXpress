package org.magiceagle.filexpress.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.magiceagle.filexpress.DTOS.FriendRequestdto;
import org.magiceagle.filexpress.DTOS.RequestDTO;
import org.magiceagle.filexpress.DTOS.chatDTO;
import org.magiceagle.filexpress.DTOS.messagueDTO;
import org.magiceagle.filexpress.Entities.Chat;
import org.magiceagle.filexpress.Entities.Message;
import org.magiceagle.filexpress.Services.Chating;
import org.magiceagle.filexpress.Services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    @Autowired
    private Users users;

    @Autowired
    private Chating chating;

    @GetMapping("/app/chat/hello")
    public ResponseEntity<String> hello() {
        return chating.helloWorld();
    }

    @PostMapping("/app/chat/new")
    public ResponseEntity<Chat> createNewChat(@RequestBody RequestDTO request) {
        return chating.createNewChat(request);
    }

    @GetMapping("/app/chat/get")
    public ResponseEntity<List<chatDTO>> getChats(HttpServletRequest request) {
        return chating.getChats(request);
    }

    @PostMapping("/app/chat/send")
    public ResponseEntity<Message> sendMessague(HttpServletRequest request, @RequestBody messagueDTO messagueDTO) {
        return chating.sendMessague(request,messagueDTO);
    }

    @GetMapping("/app/chat/getMessagues")
    public ResponseEntity<List<Message>> getMessagues(@RequestParam Long chatID) {
        return chating.getMessages(chatID);
    }
}
