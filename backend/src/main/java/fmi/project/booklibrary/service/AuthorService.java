package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Author;

import java.util.Set;

public interface AuthorService {
    Author addAuthor(Author author);

    void removeAuthor(Long id);

    void updateAuthor(Author author);

    Author findById(Long id);

    Set<Author> findAllByFirstName(String firstName);

    Set<Author> findAllByLastName(String lastName);

    Set<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    Set<Author> findAllAuthors();
}
