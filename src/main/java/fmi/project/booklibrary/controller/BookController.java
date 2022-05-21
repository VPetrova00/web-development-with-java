package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.BookDto;
import fmi.project.booklibrary.mapper.BookDtoMapper;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/book")
public class BookController {

    private BookDtoMapper bookMapper;

    private BookService bookService;

    @Autowired
    public BookController(BookDtoMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public BookDto findBookByTitle(@PathVariable Long id) {
        Book resultBook = this.bookService.findById(id);
        return this.bookMapper.convertToDto(resultBook);
    }
}
