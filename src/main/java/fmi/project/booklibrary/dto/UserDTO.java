package fmi.project.booklibrary.dto;

import fmi.project.booklibrary.model.User;

public class UserDTO {
    public Long id;

    @NotEmpty(message = "Not entered username")
    public String username;

    @NotEmpty(message = "Not entered password")
    public String password;

    @NotEmpty(message = "Email must be entered.")
    public String email;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
