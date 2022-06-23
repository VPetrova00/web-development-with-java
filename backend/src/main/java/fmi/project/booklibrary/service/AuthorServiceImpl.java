package fmi.project.booklibrary.service;

import fmi.project.booklibrary.exception.ResourceAlreadyExists;
import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        if (this.authorRepository.existsAuthorByFirstNameAndDescription(author.getFirstName(), author.getDescription())) {
            throw new ResourceAlreadyExists(String.format("Author %s is existent in the database", author.getFirstName()));
        }
        return this.authorRepository.save(author);
    }

    @Override
    public void removeAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Author> findAuthorsByFirstName(String firstName) {
        return this.authorRepository.findAllByFirstName(firstName);
    }

    @Override
    public Set<Author> findAuthorsByLastName(String lastName) {
        return this.authorRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<Author> findAuthorsByFirstNameAndLastName(String firstName, String lastName) {
        return this.authorRepository.findAuthorsByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Set<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }
}
