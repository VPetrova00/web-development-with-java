package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private static final String messageNotFound = "User is not found.";

    @Autowired
    private IUserRepository userRepository;

    public void addUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException(String.format("%s %s already exists.",
                    user.getUsername()
            ));
        }

        userRepository.save(user);
    }

    public List<User> getAllusers() {
        LinkedList<User> allUsers = new LinkedList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(messageNotFound));
    }

    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new NoSuchElementException(messageNotFound);
        }

        userRepository.save(user);
    }

    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException(messageNotFound);
        }

        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
