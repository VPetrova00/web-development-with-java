package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Set<User> findAll();

    Set<User> findByUsername(String username);

    Boolean existsUserByEmail(String email);
}
