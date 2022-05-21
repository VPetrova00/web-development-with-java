package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAlluserDTOs() {
        return userService.getAllUsers()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public UserDTO getuserDTO(@PathVariable("id") long id) {
        return new UserDTO(userService.getUser(id));
    }

    @PostMapping
    public void adduser(@Valid @RequestBody UserDTO userDTO) {
        userService.addUser(userService.toUser(userDTO));
    }

    @PutMapping
    public void updateuser(@Valid @RequestBody UserDTO userDTO) {
        userService.updateUser(userService.toUser(userDTO));
    }

    @DeleteMapping(path = "{id}")
    public void deleteuser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
