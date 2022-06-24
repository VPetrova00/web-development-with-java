package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.CollectionDto;
import fmi.project.booklibrary.mapper.CollectionDtoMapper;
import fmi.project.booklibrary.model.Collection;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.service.CollectionService;
import fmi.project.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library/collections")
public class CollectionController {

    private final CollectionService collectionService;

    private final CollectionDtoMapper collectionMapper;

    private final UserService userService;

    @Autowired
    public CollectionController(CollectionService collectionService, CollectionDtoMapper collectionMapper, UserService userService) {
        this.collectionService = collectionService;
        this.collectionMapper = collectionMapper;
        this.userService = userService;
    }

    @PostMapping
    @RequestMapping("/collection/add")
    public CollectionDto addCollection(@RequestBody CollectionDto collectionDto) {
        Collection collection = this.collectionMapper.convertToEntity(collectionDto);
        collection = this.collectionService.addCollection(collection);
        return this.collectionMapper.convertToDto(collection);
    }

    @DeleteMapping
    @RequestMapping("/collection/delete/{id}")
    public void deleteCollection(@PathVariable Long id) {
        this.collectionService.removeCollection(id);
    }

    @PutMapping
    @RequestMapping("/collection/update")
    public CollectionDto updateCollection(@RequestBody CollectionDto collectionDto) {
        Collection collection = this.collectionMapper.convertToEntity(collectionDto);
        collection.setId(collectionDto.getId());

        //update the user who owns this collection
        User user = collection.getUser();
        this.userService.updateUser(user);

        this.collectionService.updateCollection(collection);
        return this.collectionMapper.convertToDto(collection);
    }

    @GetMapping
    @RequestMapping("/all")
    public Set<CollectionDto> findAllCollections() {
        Set<Collection> collections = this.collectionService.findAllCollections();
        return this.collectionMapper.convertToDtos(collections);
    }

    @GetMapping
    @RequestMapping("/collection/id/{id}")
    public CollectionDto findCollectionById(@PathVariable Long id) {
        return this.collectionMapper.convertToDto(
                this.collectionService.findCollectionById(id)
        );
    }

    @GetMapping
    @RequestMapping("/collection/name/{collectionName}")
    public CollectionDto findCollectionByCollectionName(@PathVariable String collectionName) {
        return this.collectionMapper.convertToDto(
                this.collectionService.findCollectionByCollectionName(collectionName)
        );
    }
}
