package com.cg.dto;

import com.cg.entity.User;

public class UserDTO {
    private int id;
    private String userName;
    private String password;
 
    // Default constructor, getters, setters, and to/from entity methods
    public UserDTO() {}
 
    public UserDTO(int userId, String userName, String password) {
        this.id = userId;
        this.userName = userName;
        this.password = password;
    }
 
    public int getUserId() {
        return id;
    }
 
    public void setUserId(int userId) {
        this.id = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    // Convert from User entity to DTO
    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getId(), user.getuName(), user.getPassword());
    }
 
    // Convert from DTO to User entity
    public User toEntity() {
        return new User(this.id, this.userName, this.password);
    }
}