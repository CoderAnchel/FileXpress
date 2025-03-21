package org.magiceagle.filexpress.WebShocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private final Map<String, Map<String, WebSocketSession>> chatSessions = new ConcurrentHashMap<>();

    public void addSession(String chatId, String uerId, WebSocketSession session) {
        chatSessions.computeIfAbsent(chatId,k -> new ConcurrentHashMap<>()).put(uerId,session);
    }

    public void removeSession(String chatId, String userId) {
        Map<String, WebSocketSession> users = chatSessions.get(chatId);
        if (users != null) {
            System.out.println("Before removal: " + users);
            users.remove(userId);
            System.out.println("After removal: " + users);
//            if (users.isEmpty()) {
//                chatSessions.remove(chatId);
//            }
        }
    }

    public Map<String, WebSocketSession> getSessions(String chatId) {
        return chatSessions.getOrDefault(chatId, new ConcurrentHashMap<>());
    }
}
