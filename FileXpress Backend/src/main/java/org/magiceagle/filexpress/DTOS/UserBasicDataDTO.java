package org.magiceagle.filexpress.DTOS;

public class UserBasicDataDTO {
    private Long id;

    private String Name;

    private String Username;

    private String Phone;

    private String email;

    private String bio;


    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getName(){
        return this.Name;
    }

    public void setPhone(String Phone){
        this.Phone = Phone;
    }

    public String getPhone(){
        return this.Phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getBio(){
        return this.bio;
    }

    public void setUsername(String Username){
        this.Username = Username;
    }

    public String getUsername(){
        return this.Username;
    }
}
