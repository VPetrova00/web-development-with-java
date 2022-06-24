package fmi.project.booklibrary.service;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.model.User;

import java.util.Set;

public interface UserService {

    User addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User findById(Long id);

    Set<User> findAllUsers();

    Set<User> findByUsername(String username);

    User findUserByEmail(String email);
}
