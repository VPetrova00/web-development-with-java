package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);

    List<Book> findAll();
}
