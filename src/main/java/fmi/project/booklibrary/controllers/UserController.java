package fmi.project.booklibrary.controllers;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.services.UserService;
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
        return userService.getAllusers()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public UserDTO getuserDTO(@PathVariable("id") long id) {
        return new UserDTO(userService.getuser(id));
    }

    @PostMapping
    public void adduser(@Valid @RequestBody UserDTO userDTO) {
        userService.addUser(userService.toUser(userDTO));
    }

    @PutMapping
    public void updateuser(@Valid @RequestBody userDTO userDTO) {
        userService.updateuser(userService.touser(userDTO));
    }

    @DeleteMapping(path = "{id}")
    public void deleteuser(@PathVariable("id") long id) {
        userService.deleteuser(id);
    }
}
