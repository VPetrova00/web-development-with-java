package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.mapper.UserDtoMapper;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class UserController {

    private final UserDtoMapper userMapper;

    private final UserService userService;

    @Autowired
    public UserController(UserDtoMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user/add")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        User user = this.userMapper.convertToEntity(userDTO);
        user = this.userService.addUser(user);
        return this.userMapper.convertToDto(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/user/delete/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        User updatedUser = this.userMapper.convertToEntity(userDTO);
        updatedUser.setId(userDTO.getId());
        this.userService.updateUser(updatedUser);
        return this.userMapper.convertToDto(updatedUser);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public Set<UserDTO> findAllUsers() {
        Set<User> resultUsers = this.userService.findAllUsers();
        return this.userMapper.convertToDtos(resultUsers);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/user/id/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        User resultUser = this.userService.findById(id);
        return this.userMapper.convertToDto(resultUser);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/users/username/{username}")
    public Set<UserDTO> findUsersByUsername(@PathVariable String username) {
        Set<User> resultUsers = this.userService.findByUsername(username);
        return this.userMapper.convertToDtos(resultUsers);
    }
}
