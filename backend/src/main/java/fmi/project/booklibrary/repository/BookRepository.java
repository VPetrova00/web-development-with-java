package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.enums.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Boolean existsBookByTitle(String title);

    Set<Book> findAll();

    Set<Book> findAllByGenre(Genre genre);

    @Query(
            value = "SELECT * FROM books " +
                    "INNER JOIN books_authors ON books.id = books_authors.book_id " +
                    "INNER JOIN authors ON books_authors.author_id = authors.id " +
                    "WHERE authors.first_name = :author",
            nativeQuery=true
    )
    Set<Book> findByAuthorFirstName(@Param("author") String author);
}
