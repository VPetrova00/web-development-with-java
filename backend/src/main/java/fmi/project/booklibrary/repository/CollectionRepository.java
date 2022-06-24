package fmi.project.booklibrary.repository;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CollectionRepository extends CrudRepository<Collection, Long> {

    Boolean existsCollectionByCollectionName(String collectionName);

    Set<Collection> findAll();

    Collection findCollectionByCollectionName(String collectionName);
}
