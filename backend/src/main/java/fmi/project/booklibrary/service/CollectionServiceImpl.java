package fmi.project.booklibrary.service;

import fmi.project.booklibrary.exception.ResourceAlreadyExists;
import fmi.project.booklibrary.exception.ResourceNotFound;
import fmi.project.booklibrary.model.Collection;
import fmi.project.booklibrary.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public Collection addCollection(Collection collection) {
        if (this.collectionRepository.existsCollectionByCollectionName(collection.getCollectionName())) {
            throw new ResourceAlreadyExists(String.format("Collection %s is existent in the database", collection.getCollectionName()));
        }

        return this.collectionRepository.save(collection);
    }

    @Override
    public void removeCollection(Long id) {
        if (!this.collectionRepository.existsById(id)) {
            throw new ResourceNotFound("The collection isn't existent in the database.");
        }

        this.collectionRepository.deleteById(id);
    }

    @Override
    public void updateCollection(Collection collection) {
        if (!this.collectionRepository.existsById(collection.getId())) {
            throw new ResourceNotFound(String.format("The collection %s isn't existent in the database.", collection.getCollectionName()));
        }

        this.collectionRepository.save(collection);
    }

    @Override
    public Collection findCollectionById(Long id) {
        return this.collectionRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Collection> findAllCollections() {
        return this.collectionRepository.findAll();
    }

    @Override
    public Collection findCollectionByCollectionName(String collectionName) {
        return this.collectionRepository.findCollectionByCollectionName(collectionName);
    }
}
