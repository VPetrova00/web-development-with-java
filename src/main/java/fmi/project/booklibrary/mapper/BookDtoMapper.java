package fmi.project.booklibrary.mapper;

import fmi.project.booklibrary.dto.BookDto;
import fmi.project.booklibrary.model.Book;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookDtoMapper {

    public Book convertToEntity(BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthors(), bookDto.getPrice(), bookDto.getPages(), bookDto.getCoverType(), bookDto.getGenre());
    }

    public BookDto convertToDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthors(), book.getDescription(), book.getPrice(), book.getPages(), book.getCoverType(), book.getGenre());
    }

    public Set<BookDto> convertToDtos(Set<Book> books) {
        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }
}
