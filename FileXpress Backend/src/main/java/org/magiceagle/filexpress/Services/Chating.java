package org.magiceagle.filexpress.Services;

import jakarta.servlet.http.HttpServletRequest;
import org.magiceagle.filexpress.DTOS.RequestDTO;
import org.magiceagle.filexpress.DTOS.chatDTO;
import org.magiceagle.filexpress.DTOS.messagueDTO;
import org.magiceagle.filexpress.Entities.Chat;
import org.magiceagle.filexpress.Entities.Message;
import org.magiceagle.filexpress.Entities.User;
import org.magiceagle.filexpress.Repositorys.ChatRepository;
import org.magiceagle.filexpress.Repositorys.MessagueRepository;
import org.magiceagle.filexpress.Repositorys.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Chating {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessagueRepository messagueRepository;

    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello from Chat Service!");
    }

   public ResponseEntity<Chat> createNewChat(RequestDTO request) {
       Optional<User> a = userRepo.findById(request.getFrom_id());
       Optional<User> b = userRepo.findById(request.getTo_id());

       if (a.isEmpty() || b.isEmpty()) {
           return ResponseEntity.badRequest().build();
       }

       Optional<Chat> findedChatA = chatRepository.findByAAndB(a.get(), b.get());
       Optional<Chat> findedChatB = chatRepository.findByAAndB(b.get(), a.get());

       if (findedChatA.isPresent() || findedChatB.isPresent()) {
           return ResponseEntity.badRequest().build();
       }

       Chat chat = new Chat();
       Date now = new Date();

       chat.setCreated(now);
       chat.setA(a.get());
       chat.setB(b.get());

       chatRepository.save(chat);
       return ResponseEntity.ok(chat);
   }

   public ResponseEntity<List<chatDTO>> getChats(HttpServletRequest request) {
       Integer id = (Integer) request.getAttribute("id");
       Long idLong = id.longValue();
       Optional<User> user = userRepo.findById(idLong);
       List<chatDTO> chatDTOS = new ArrayList<>();

       List<Chat> findedChats = chatRepository.findByAOrB(user.get(), user.get());

       for(Chat chat : findedChats) {
              chatDTO chatDTO = new chatDTO();
              chatDTO.setChatID(chat.getId());
              chatDTO.setUserID(chat.getA().getId().equals(idLong) ? chat.getB().getId() : chat.getA().getId());
              chatDTO.setName(chat.getA().getId().equals(idLong) ? chat.getB().getName() : chat.getA().getName());
              chatDTO.setUsername(chat.getA().getId().equals(idLong) ? chat.getB().getUsername() : chat.getA().getUsername());
              chatDTO.setLastMessague(chat.getLastMessage());
              chatDTOS.add(chatDTO);
       }

         return ResponseEntity.ok(chatDTOS);
   }

   public ResponseEntity<Message> sendMessague(HttpServletRequest request, messagueDTO messagueDTO) {
       Integer id = (Integer) request.getAttribute("id");
       Long idLong = id.longValue();
       Optional<User> user = userRepo.findById(idLong);
       Date now = new Date();
       String time = now.getHours() + ":" + now.getMinutes();
       Message message = new Message();
       message.setMessague(messagueDTO.getMessague());
       message.setChatID(messagueDTO.getChatID());
       message.setUserID(idLong);
       message.setTime(time);
       message.setTimestamp(now);


       return ResponseEntity.ok(messagueRepository.save(message));
   }

   public ResponseEntity<List<Message>> getMessages(Long chatID) {
       Pageable pageable =  PageRequest.of(0, 40);
       List<Message> messages = messagueRepository.findByChatIDOrderByTimestampAsc(chatID,  pageable);
       return ResponseEntity.ok(messages);
   }

}
