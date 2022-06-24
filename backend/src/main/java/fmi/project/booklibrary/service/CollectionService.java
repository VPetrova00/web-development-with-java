package fmi.project.booklibrary.service;

import fmi.project.booklibrary.model.Collection;

import java.util.Set;

public interface CollectionService {
    Collection addCollection(Collection collection);

    void removeCollection(Long id);

    void updateCollection(Collection collection);

    Collection findCollectionById(Long id);

    Set<Collection> findAllCollections();

    Collection findCollectionByCollectionName(String collectionName);
}
