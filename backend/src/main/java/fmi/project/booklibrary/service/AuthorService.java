package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Author;

import java.util.Set;

public interface AuthorService {

    Author addAuthor(Author author);

    void removeAuthor(Long id);

    void updateAuthor(Author author);

    Author findAuthorById(Long id);

    Set<Author> findAuthorsByFirstName(String firstName);

    Set<Author> findAuthorsByLastName(String lastName);

    Set<Author> findAuthorsByFirstNameAndLastName(String firstName, String lastName);

    Set<Author> findAllAuthors();
}
