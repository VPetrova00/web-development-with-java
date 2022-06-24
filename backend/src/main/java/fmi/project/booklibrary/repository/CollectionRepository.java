package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Long> {

    Boolean existsCollectionByCollectionName(String collectionName);

    Set<Collection> findAll();

    Collection findCollectionByCollectionName(String collectionName);
}
