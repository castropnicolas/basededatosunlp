package ar.edu.unlp.model;

import java.util.Date;

public class User {

    private String id;
    private String username;
    private String password;
    private String name;
    private Date createdAt;

    public User() {

    }

    public User(String anUsername, String aPassword, String aName) {
        this.setUsername(anUsername);
        this.setName(aName);
        this.setPassword(aPassword);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String anUsername) {
        this.username = anUsername;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String aPassword) {
        this.password = aPassword;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
