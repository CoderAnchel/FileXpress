package org.magiceagle.filexpress.DTOS;

import org.magiceagle.filexpress.Entities.User;

import java.util.List;

public class UserSearchResponseDTO {
    private List<UserBasicDataDTO> users = null;

    private Long searchID = null;

    public List<UserBasicDataDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserBasicDataDTO> users) {
        this.users = users;
    }

    public Long getSearchID() {
        return searchID;
    }

    public void setSearchID(Long searchID) {
        this.searchID = searchID;
    }
}
