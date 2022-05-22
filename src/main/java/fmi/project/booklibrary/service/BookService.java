package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    Book createBook(Book book);

    void removeBook(Book book);

    void updateBook(Book book);

    Book findById(Long id);

    Set<Book> findAllBooksByAuthorFirstName(String author);

    List<Book> findAllBooks();
}
