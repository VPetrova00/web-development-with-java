package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IUserRepository extends CrudRepository<User, Long> {
    Set<User> findAll();

//    @Query(
//            value = "SELECT * FROM users " +
//                    "INNER JOIN books_authors ON books.id = books_authors.book_id " +
//                    "INNER JOIN authors ON books_authors.author_id = authors.id " +
//                    "WHERE authors.first_name = 'David'",
//            nativeQuery = true
//    )

    Set<User> findByUsername(String username);
}
