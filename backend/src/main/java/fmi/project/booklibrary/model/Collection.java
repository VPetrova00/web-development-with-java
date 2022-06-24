package fmi.project.booklibrary.model;

import fmi.project.booklibrary.exception.ResourceNotFound;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true)
    String collectionName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
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

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (!this.books.contains(book)) {
              throw new ResourceNotFound("This collection doesn't contain the specified book.");
        }

        this.books.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return collectionName.equals(that.collectionName) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionName, user);
    }
}
