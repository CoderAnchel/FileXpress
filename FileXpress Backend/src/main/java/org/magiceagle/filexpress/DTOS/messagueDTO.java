package org.magiceagle.filexpress.DTOS;

public class messagueDTO {
    private String messague;
    private Long chatID;

    public void setMessague(String messague) {
        this.messague = messague;
    }

    public String getMessague() {
        return messague;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public Long getChatID() {
        return chatID;
    }
}
