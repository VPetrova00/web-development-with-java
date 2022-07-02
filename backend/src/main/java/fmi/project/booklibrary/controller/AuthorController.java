package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.AuthorDto;
import fmi.project.booklibrary.mapper.AuthorDtoMapper;
import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class AuthorController {
    private final AuthorDtoMapper authorMapper;

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorDtoMapper authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/author/add")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) {
        Author author = this.authorMapper.convertToEntity(authorDto);
        author = this.authorService.addAuthor(author);
        return this.authorMapper.convertToDto(author);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/author/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        this.authorService.removeAuthor(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/author/update")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        Author updatedAuthor = this.authorMapper.convertToEntity(authorDto);
        updatedAuthor.setId(authorDto.getId());
        this.authorService.updateAuthor(updatedAuthor);
        return this.authorMapper.convertToDto(updatedAuthor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authors")
    public Set<AuthorDto> findAllAuthors() {
        Set<Author> resultAuthors = this.authorService.findAllAuthors();
        return this.authorMapper.convertToDtos(resultAuthors);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/author/id/{id}")
    public AuthorDto findAuthorById(@PathVariable Long id) {
        Author resultAuthor = this.authorService.findAuthorById(id);
        return this.authorMapper.convertToDto(resultAuthor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/authors/firstName/{firstName}")
    public Set<AuthorDto> findAllByFirstName(@PathVariable String firstName) {
        Set<Author> resultAuthor = this.authorService.findAuthorsByFirstName(firstName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/authors/lastName/{lastName}")
    public Set<AuthorDto> findAllByLastName(@PathVariable String lastName) {
        Set<Author> resultAuthor = this.authorService.findAuthorsByLastName(lastName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/authors/names/{firstName}/{lastName}")
    public Set<AuthorDto> findAuthorByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        Set<Author> resultAuthor = this.authorService.findAuthorsByFirstNameAndLastName(firstName, lastName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }
}
