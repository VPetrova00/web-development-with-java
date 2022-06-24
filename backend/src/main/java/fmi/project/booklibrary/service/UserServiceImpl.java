package fmi.project.booklibrary.service;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.exception.ResourceAlreadyExists;
import fmi.project.booklibrary.exception.ResourceNotFound;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        if (this.userRepository.existsUserByEmail(user.getEmail())) {
            throw new ResourceAlreadyExists(String.format("User with this email %s already exists in the database.",
                    user.getEmail()));
        }

        return this.userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (!this.userRepository.existsById(user.getId())) {
            throw new ResourceNotFound(String.format("The user %s isn't existent in the database.", user.getEmail()));
        }

        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        if (!this.userRepository.existsById(id)) {
            throw new ResourceNotFound("The user isn't existent in the database.");
        }

        this.userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Set<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }
}
