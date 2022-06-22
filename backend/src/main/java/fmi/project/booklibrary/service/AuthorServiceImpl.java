package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        return null;
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
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Author> findAllByFirstName(String firstName) {
        return this.authorRepository.findAllByFirstName(firstName);
    }

    @Override
    public Set<Author> findAllByLastName(String lastName) {
        return this.authorRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return this.authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Set<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }
}
