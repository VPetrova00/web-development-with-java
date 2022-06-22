package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.BookDto;
import fmi.project.booklibrary.mapper.BookDtoMapper;
import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class BookController {

    private BookDtoMapper bookMapper;

    private BookService bookService;

    @Autowired
    public BookController(BookDtoMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    //fix the preservation of existing authors
    @PostMapping
    public BookDto addBook(@RequestBody BookDto bookDto) throws IllegalArgumentException {
        Book book = this.bookMapper.convertToEntity(bookDto);
        try {
            book = this.bookService.addBook(book);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.bookMapper.convertToDto(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.removeBook(id);
    }

    //fix the preservation of existing authors and books => update the one from the DB
    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        Book updatedBook = this.bookMapper.convertToEntity(bookDto);
        updatedBook.setId(bookDto.getId());
        this.bookService.updateBook(updatedBook);
        return this.bookMapper.convertToDto(updatedBook);
    }

    @GetMapping
    public Set<BookDto> findAllBooks() {
        Set<Book> resultBooks = this.bookService.findAllBooks();
        return this.bookMapper.convertToDtos(resultBooks);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public BookDto findBookById(@PathVariable Long id) {
        Book resultBook = this.bookService.findById(id);
        return this.bookMapper.convertToDto(resultBook);
    }

    @GetMapping
    @RequestMapping("/books/{author}")
    public Set<BookDto> findBooksByAuthorFirstName(@PathVariable String author) {
        Set<Book> resultBooks = this.bookService.findAllBooksByAuthorFirstName(author);
        return this.bookMapper.convertToDtos(resultBooks);
    }
}
