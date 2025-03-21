package org.magiceagle.filexpress.DTOS;

import java.util.Date;

public class SearchDTO {
    private Long searchID;
    private String type;
    private Date date;
    private String value;

    public Long getSearchID() {
        return searchID;
    }

    public void setSearchID(Long searchID) {
        this.searchID = searchID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
