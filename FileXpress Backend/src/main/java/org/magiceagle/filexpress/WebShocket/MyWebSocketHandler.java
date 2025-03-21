package org.magiceagle.filexpress.WebShocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.magiceagle.filexpress.Entities.Message;
import org.magiceagle.filexpress.Repositorys.MessagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final SessionManager sessionManager = new SessionManager();
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MessagueRepository messagueRepository;

    /*
        We need to add more independent methods in order to be able of importing them into my controller or service and integrated easly with the crud operations for the dynamic notis system
     */

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Map payload = objectMapper.readValue(message.getPayload(), Map.class);
        Date date = new Date();

        String type = (String) payload.get("type");
        if (type.equals("register")) {
            // Aquí aseguramos que estamos tratando con Integer, y luego convertimos a String
            Integer chatIdInteger = (Integer) payload.get("chatId");
            Integer userIdInteger = (Integer) payload.get("userId");

            // Convertimos Integer a String
            String chatId = String.valueOf(chatIdInteger);
            String userId = String.valueOf(userIdInteger);

            sessionManager.addSession(chatId, userId, session);
            session.sendMessage(new TextMessage("Registered for chat: " + chatId));
        } else if (type.equals("message")) {
            // Aquí aseguramos que estamos tratando con Integer, y luego convertimos a String
            Integer chatIdInteger = (Integer) payload.get("chatId");
            Integer userIdInteger = (Integer) payload.get("userId");
            // Convertimos Integer a String
            String chatId = String.valueOf(chatIdInteger);
            String userId = String.valueOf(userIdInteger);

            String messageText = (String) payload.get("message");
            Message messageEnt = new Message();
            messageEnt.setChatID(Long.parseLong(chatId));
            messageEnt.setUserID(Long.parseLong(userId));
            messageEnt.setMessague(messageText);
            messageEnt.setTime(date.getHours()+":"+date.getMinutes());
            messageEnt.setTimestamp(date);
            Map<String, WebSocketSession> sessions = sessionManager.getSessions(chatId);
            messagueRepository.save(messageEnt);
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(messageEnt)));
            for (Map.Entry<String, WebSocketSession> entry : sessions.entrySet()) {
                if (!Objects.equals(entry.getKey(), userId)) {
                    entry.getValue().sendMessage(new TextMessage(objectMapper.writeValueAsString(messageEnt)));
                }
            }
        } else if (type.equals("disconnect")) {
            // Aquí aseguramos que estamos tratando con Integer, y luego convertimos a String
            Integer chatIdInteger = (Integer) payload.get("chatId");
            Integer userIdInteger = (Integer) payload.get("userId");
            // Convertimos Integer a String
            String chatId = String.valueOf(chatIdInteger);
            String userId = String.valueOf(userIdInteger);
            sessionManager.removeSession(chatId, userId);
            session.sendMessage(new TextMessage("Disconnected from chat: " + chatId));
        }
    }
}
