package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    void removeBook(Book book);

    void updateBook(Book book);

    Book findById();

    List<Book> findAllBooks();
}
