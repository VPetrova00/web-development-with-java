package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.enums.Genre;

import java.util.Set;

public interface BookService {
    Book addBook(Book book);

    void removeBook(Long id);

    void updateBook(Book book);

    Book findById(Long id);

    Set<Book> findAllBooksByAuthorFirstName(String author);

    Set<Book> findAllBooks();

    Set<Book> findAllBooksByGenre(Genre genre);
}
