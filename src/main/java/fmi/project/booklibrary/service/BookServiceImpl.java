package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }
}
