package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.BookDto;
import fmi.project.booklibrary.mapper.BookDtoMapper;
import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.enums.Genre;
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

    @PostMapping("/book/add")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book book = this.bookMapper.convertToEntity(bookDto);
        try {
            book = this.bookService.addBook(book);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return this.bookMapper.convertToDto(book);
    }

    @DeleteMapping("book/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.removeBook(id);
    }

    @PutMapping("/book/update")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        Book updatedBook = this.bookMapper.convertToEntity(bookDto);
        updatedBook.setId(bookDto.getId());
        this.bookService.updateBook(updatedBook);
        return this.bookMapper.convertToDto(updatedBook);
    }

    @GetMapping("/books")
    public Set<BookDto> findAllBooks() {
        Set<Book> resultBooks = this.bookService.findAllBooks();
        return this.bookMapper.convertToDtos(resultBooks);
    }

    @GetMapping
    @RequestMapping("/book/{id}")
    public BookDto findBookById(@PathVariable Long id) {
        Book resultBook = this.bookService.findById(id);
        return this.bookMapper.convertToDto(resultBook);
    }

    @GetMapping
    @RequestMapping("/books/author/{author}")
    public Set<BookDto> findBooksByAuthorFirstName(@PathVariable String author) {
        Set<Book> resultBooks = this.bookService.findAllBooksByAuthorFirstName(author);
        return this.bookMapper.convertToDtos(resultBooks);
    }

    @GetMapping
    @RequestMapping("/books/genre/{genre}")
    public Set<BookDto> findAllBooksByGenre(@PathVariable Genre genre) {
        Set<Book> resultBooks = this.bookService.findAllBooksByGenre(genre);
        return this.bookMapper.convertToDtos(resultBooks);
    }
}
