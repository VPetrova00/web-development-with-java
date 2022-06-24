package fmi.project.booklibrary.dto;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.User;

import java.util.Set;

public class CollectionDto {
    Long id;

    String collectionName;

    User user;

    public CollectionDto(Long id, String collectionName, User user) {
        this.id = id;
        this.collectionName = collectionName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
