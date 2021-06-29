package ar.edu.unlp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {

    private String id;

    @NotEmpty
    private String name;

    @NotNull
    private String username;

    private Date createdAt;

    private Integer version;

    public UserDTO() {

    }

    public UserDTO(String anId, String anUsername, String aName, Date createdAt, Integer version) {
        this.setId(anId);
        this.setName(aName);
        this.setUsername(anUsername);
        this.setCreatedAt(createdAt);
        this.setVersion(version);
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
