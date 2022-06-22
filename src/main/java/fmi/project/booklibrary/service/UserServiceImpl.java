package fmi.project.booklibrary.service;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException(String.format("%s already exists.",
                    user.getUsername()
            ));
        }

        return userRepository.save(user);
    }

    @Override
    public Set<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(this.messageNotFound));
    }

    @Override
    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new NoSuchElementException(this.messageNotFound);
        }

        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException(this.messageNotFound);
        }

        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<User> findAllBooks() {
        return this.userRepository.findAll();
    }

    @Override
    public Set<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User toUser(UserDTO dto) {
        User user = new User();

        user.setUsername(dto.username);
        user.setPassword(dto.password);
        user.setEmail(dto.email);

        return user;
    }
}
