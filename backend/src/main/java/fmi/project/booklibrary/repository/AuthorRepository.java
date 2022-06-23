package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Boolean existsAuthorByFirstNameAndDescription(String firstName, String description);

    Set<Author> findAllByFirstName(String firstName);

    Set<Author> findAllByLastName(String lastName);

    Set<Author> findAuthorsByFirstNameAndLastName(String firstName, String lastName);

    Set<Author> findAll();
}
