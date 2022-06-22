package fmi.project.booklibrary.service;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.model.User;

import java.util.Set;

public interface UserService {
    public String messageNotFound = "User is not found.";

    public User addUser(User user);

    public Set<User> getAllUsers() ;

    public User getUser(long id);

    public void updateUser(User user);

    public void deleteUser(long id);

    public User findById(Long id);

    public Set<User> findAllUsers();

    public Set<User> findByUsername(String username);

    public User toUser(UserDTO dto);
}
