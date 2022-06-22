package fmi.project.booklibrary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String collectionName;

    @ManyToOne
    User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "collections_books",
            joinColumns = { @JoinColumn(name = "collection_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books;

    public Collection(Long id, String collectionName, User user) {
        this.id = id;
        this.collectionName = collectionName;
        this.user = user;
    }

    public Collection() {
        this.collectionName = null;
        this.user = null;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
