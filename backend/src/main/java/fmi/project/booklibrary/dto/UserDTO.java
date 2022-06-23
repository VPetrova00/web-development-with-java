package fmi.project.booklibrary.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
    public Long id;

    @NotEmpty(message = "Not entered username")
    public String username;

    @NotEmpty(message = "Not entered password")
    public String password;

    @NotEmpty(message = "Email must be entered.")
    public String email;

    public UserDTO(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
