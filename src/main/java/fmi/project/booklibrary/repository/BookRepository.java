package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Set<Book> findAll();

    @Query(
            value = "SELECT * FROM books " +
                    "INNER JOIN books_authors ON books.id = books_authors.book_id " +
                    "INNER JOIN authors ON books_authors.author_id = authors.id " +
                    "WHERE authors.first_name = 'David'",
            nativeQuery = true
    )
    Set<Book> findByAuthorFirstName(String author);
}
