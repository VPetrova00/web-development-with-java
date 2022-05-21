package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByLastName(String lastName);

    List<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
