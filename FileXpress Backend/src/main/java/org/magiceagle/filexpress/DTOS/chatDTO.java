package org.magiceagle.filexpress.DTOS;

import org.magiceagle.filexpress.Entities.Chat;

public class chatDTO {
    private Long chatID;
    private Long userID;
    private String name;
    private String username;
    private String lastMessague;
    private String lastTime  = "00:00";

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public Long getChatID() {
        return chatID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLastMessague(String lastMessague) {
        this.lastMessague = lastMessague;
    }

    public String getLastMessague() {
        return lastMessague;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastTime() {
        return lastTime;
    }
}
