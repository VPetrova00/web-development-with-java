package fmi.project.booklibrary.mapper;

import fmi.project.booklibrary.model.Author;
import org.springframework.stereotype.Component;
import fmi.project.booklibrary.dto.AuthorDto;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorDtoMapper {
    public Author convertToEntity(AuthorDto authorDto) {
        return new Author(authorDto.getFirstName(), authorDto.getLastName(), authorDto.getDescription());
    }

    public AuthorDto convertToDto(Author author) {
        return new AuthorDto(author.getId(), author.getFirstName(), author.getLastName(), author.getDescription(), author.getBooks());
    }

    public Set<AuthorDto> convertToDtos(Set<Author> authors) {
        return authors
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }
}
