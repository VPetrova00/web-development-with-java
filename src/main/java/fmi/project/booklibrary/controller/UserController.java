package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.mapper.UserDtoMapper;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    private UserDtoMapper userMapper;

    private UserService userService;

    @Autowired
    public UserController(UserDtoMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUserDTOs() {
        return userService.getAllUsers()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public UserDTO getUserDTO(@PathVariable("id") long id) {
        return new UserDTO(userService.getUser(id));
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        User user = this.userMapper.convertToEntity(userDTO);
        user = this.userService.addUser(user);
        return this.userMapper.convertToDto(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        User updatedUser = this.userMapper.convertToEntity(userDTO);
        updatedUser.setId(userDTO.getId());
        this.userService.updateUser(updatedUser);
        return this.userMapper.convertToDto(updatedUser);
    }

    @GetMapping
    public Set<UserDTO> findAllBooks() {
        Set<User> resultUserBooks = this.userService.findAllBooks();
        return this.userMapper.convertToDtos(resultUserBooks);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        User resultUser = this.userService.findById(id);
        return this.userMapper.convertToDto(resultUser);
    }

    @GetMapping
    @RequestMapping("/users/{username}")
    public Set<UserDTO> findUserByUsername(@PathVariable String username) {
        Set<User> resultUsers = this.userService.findByUsername(username);
        return this.userMapper.convertToDtos(resultUsers);
    }
}
