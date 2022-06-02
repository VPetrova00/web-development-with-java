package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Book;

import java.util.Set;

public interface BookService {
    Book addBook(Book book);

    void removeBook(Book book);

    void updateBook(Book book);

    Book findById(Long id);

    Set<Book> findAllBooksByAuthorFirstName(String author);

    Set<Book> findAllBooks();
}
