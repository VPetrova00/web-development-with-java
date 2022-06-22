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
    private AuthorDtoMapper authorMapper;

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorDtoMapper authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    //fix the preservation of existing authors
    @PostMapping("/author/add")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) throws IllegalArgumentException {
        Author author = this.authorMapper.convertToEntity(authorDto);
        try {
            author = this.authorService.addAuthor(author);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.authorMapper.convertToDto(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        this.authorService.removeAuthor(id);
    }

    //fix the preservation of existing authors => update the one from the DB
    @PutMapping
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        Author updatedAuthor = this.authorMapper.convertToEntity(authorDto);
        updatedAuthor.setId(authorDto.getId());
        this.authorService.updateAuthor(updatedAuthor);
        return this.authorMapper.convertToDto(updatedAuthor);
    }

    @GetMapping
    public Set<AuthorDto> findAllAuthors() {
        Set<Author> resultAuthors = this.authorService.findAllAuthors();
        return this.authorMapper.convertToDtos(resultAuthors);
    }

    @GetMapping
    @RequestMapping("/author/{id}")
    public AuthorDto findAuthorById(@PathVariable Long id) {
        Author resultAuthor = this.authorService.findById(id);
        return this.authorMapper.convertToDto(resultAuthor);
    }

    @GetMapping
    @RequestMapping("/author/{firstName}")
    public Set<AuthorDto> findAllByFirstName(@PathVariable String firstName) {
        Set<Author> resultAuthor = this.authorService.findAllByFirstName(firstName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }
    @GetMapping
    @RequestMapping("/author/{lastName}")
    public Set<AuthorDto> findAllByLastName(@PathVariable String lastName) {
        Set<Author> resultAuthor = this.authorService.findAllByLastName(lastName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }

    @GetMapping
    @RequestMapping("/author/{firstName}/{lastName}")
    public Set<AuthorDto> findAuthorByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        Set<Author> resultAuthor = this.authorService.findAuthorByFirstNameAndLastName(firstName, lastName);
        return this.authorMapper.convertToDtos(resultAuthor);
    }


}
