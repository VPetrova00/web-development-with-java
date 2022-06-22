package fmi.project.booklibrary.mapper;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {
    public User convertToEntity(UserDTO userDto) {
        return new User(userDto.getPassword(), userDto.getEmail(), userDto.getUsername());
    }

    public UserDTO convertToDto(User user) {
        return new UserDTO(user.getPassword(), user.getEmail(), user.getUsername());
    }

    public Set<UserDTO> convertToDtos(Set<User> users) {
        return users
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }
}
