package fmi.project.booklibrary.service;

import fmi.project.booklibrary.exception.ResourceAlreadyExists;
import fmi.project.booklibrary.exception.ResourceNotFound;
import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.enums.Genre;
import fmi.project.booklibrary.repository.AuthorRepository;
import fmi.project.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book addBook(Book book) {
        if (this.bookRepository.existsBookByTitle(book.getTitle())) {
            throw new ResourceAlreadyExists(String.format("Book %s with description - %s - is existent in the database", book.getTitle(), book.getDescription()));
        }

        Set<Author> newAuthors = new HashSet<>();
        for (Author author : book.getAuthors()) {
            if (!this.authorRepository.existsAuthorByFirstNameAndDescription(author.getFirstName(), author.getDescription())) {
                newAuthors.add(author);
            }
        }

        book.setAuthors(newAuthors);
        return this.bookRepository.save(book);
    }

    @Override
    public void removeBook(Long id) {
        if (!this.bookRepository.existsById(id)) {
            throw new ResourceNotFound("The book isn't existent in the database.");
        }

        this.bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        if (!this.bookRepository.existsById(book.getId())) {
            throw new ResourceNotFound(String.format("The book %s isn't existent in the database.", book.getTitle()));
        }

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

    @Override
    public Set<Book> findAllBooksByGenre(Genre genre) {
        return this.bookRepository.findAllByGenre(genre);
    }
}
