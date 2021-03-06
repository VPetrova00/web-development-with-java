package fmi.project.booklibrary.controller;

import fmi.project.booklibrary.dto.CollectionDto;
import fmi.project.booklibrary.mapper.CollectionDtoMapper;
import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.Collection;
import fmi.project.booklibrary.model.User;
import fmi.project.booklibrary.service.BookService;
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

    private final BookService bookService;

    @Autowired
    public CollectionController(CollectionService collectionService, CollectionDtoMapper collectionMapper, UserService userService, BookService bookService) {
        this.collectionService = collectionService;
        this.collectionMapper = collectionMapper;
        this.userService = userService;
        this.bookService = bookService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @RequestMapping("/collection/add")
    public CollectionDto addCollection(@RequestBody CollectionDto collectionDto) {
        Collection collection = this.collectionMapper.convertToEntity(collectionDto);
        collection = this.collectionService.addCollection(collection);
        return this.collectionMapper.convertToDto(collection);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    @RequestMapping("/collection/delete/{id}")
    public void deleteCollection(@PathVariable Long id) {
        this.collectionService.removeCollection(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/all")
    public Set<CollectionDto> findAllCollections() {
        Set<Collection> collections = this.collectionService.findAllCollections();
        return this.collectionMapper.convertToDtos(collections);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/collection/id/{id}")
    public CollectionDto findCollectionById(@PathVariable Long id) {
        return this.collectionMapper.convertToDto(
                this.collectionService.findCollectionById(id)
        );
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/collection/name/{collectionName}")
    public CollectionDto findCollectionByCollectionName(@PathVariable String collectionName) {
        return this.collectionMapper.convertToDto(
                this.collectionService.findCollectionByCollectionName(collectionName)
        );
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{collectionName}/add/book/{bookId}")
    public void addBookInCollection(@PathVariable Long bookId, @PathVariable String collectionName) {
        Collection collection = this.collectionService.findCollectionByCollectionName(collectionName);
        collection.addBook(this.bookService.findById(bookId));
        this.collectionService.updateCollection(collection);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{collectionName}/remove/book/{bookId}")
    public void removeBookFromCollection(@PathVariable Long bookId, @PathVariable String collectionName) {
        Collection collection = this.collectionService.findCollectionByCollectionName(collectionName);
        Book book = this.bookService.findById(bookId);
        collection.removeBook(book);
        this.collectionService.updateCollection(collection);
    }
}
