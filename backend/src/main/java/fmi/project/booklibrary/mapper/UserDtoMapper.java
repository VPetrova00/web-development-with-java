package fmi.project.booklibrary.mapper;

import fmi.project.booklibrary.dto.UserDTO;
import fmi.project.booklibrary.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

    public User convertToEntity(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
    }

    public UserDTO convertToDto(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public Set<UserDTO> convertToDtos(Set<User> users) {
        return users
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }
}
