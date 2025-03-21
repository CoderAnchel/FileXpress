package org.magiceagle.filexpress.DTOS;

public class UserDataUpdateDTO {
    private String type;
    private String value;

    public void setType(String value) {
        this.type = value;
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
