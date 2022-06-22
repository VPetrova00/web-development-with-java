package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Set<Author> findAllByFirstName(String firstName);

    Set<Author> findAllByLastName(String lastName);

    Set<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    Set<Author> findAll();
}
