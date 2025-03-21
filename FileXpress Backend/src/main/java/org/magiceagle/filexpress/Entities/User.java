package org.magiceagle.filexpress.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class User {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Date created;

    private String name;

    private String username;

    private String bio;

    private String phone;

    private String gendre;

    private String email;

    private String password;

    private String role;

    private String departament;

    private String status;

    private String bucket;

    private int maxStorage;

    private int usedStorage;

    private int recentNotis;

    private int totalNotis;

    private Date lastLogin;

    private String lang;

    private String plan;

    private Boolean twoFactor = false;

    private Boolean publicProfile = false;

    private Boolean emailNotifications = false;

    private Boolean pushNotifications = false;

    private Boolean smsNotifications = false;

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getGendre() {
        return gendre;
    }

    public void setTwoFactor(Boolean twoFactor) {
        this.twoFactor = twoFactor;
    }

    public Boolean getTwoFactor() {
        return twoFactor;
    }

    public void setPublicProfile(Boolean publicProfile) {
        this.publicProfile = publicProfile;
    }

    public Boolean getPublicProfile() {
        return publicProfile;
    }

    public void setEmailNotifications(Boolean emailNotifications) {
        this.emailNotifications = emailNotifications;
    }

    public Boolean getEmailNotifications() {
        return emailNotifications;
    }

    public void setPushNotifications(Boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    public Boolean getPushNotifications() {
        return pushNotifications;
    }

    public void setSmsNotifications(Boolean smsNotifications) {
        this.smsNotifications = smsNotifications;
    }

    public Boolean getSmsNotifications() {
        return smsNotifications;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public void setUsedStorage(int usedStorage) {
        this.usedStorage = usedStorage;
    }

    public int getUsedStorage() {
        return usedStorage;
    }

    public void setRecentNotis(int recentNotis) {
        this.recentNotis = recentNotis;
    }

    public int getRecentNotis() {
        return recentNotis;
    }

    public void setTotalNotis(int totalNotis) {
        this.totalNotis = totalNotis;
    }

    public int getTotalNotis() {
        return totalNotis;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }
}
