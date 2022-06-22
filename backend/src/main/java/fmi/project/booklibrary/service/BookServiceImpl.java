package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        if (this.bookRepository.existsBookByTitle(book.getTitle())) {
            throw new IllegalArgumentException("Book already exists in the database");
        }
        return this.bookRepository.save(book);
    }

    @Override
    public void removeBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Book> findAllBooksByAuthorFirstName(String author) {
        return this.bookRepository.findByAuthorFirstName(author);
    }

    @Override
    public Set<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }
}
