package fmi.project.booklibrary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany(mappedBy = "users")
    private Set<Book> allBooks;

    @ManyToMany(mappedBy = "usersWithFavBooks")
    private Set<Book> favouriteBooks;

    public User() {
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public User(String password, String email, String username, Set<Book> books, Set<Book> favouriteBooks) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.allBooks = books;
        this.favouriteBooks = favouriteBooks;
    }

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setBooks(Set<Book> books) {
        this.allBooks = books;
    }

    public Set<Book> getBooks() {
        return this.allBooks;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setFavouriteBooks(Set<Book> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public Set<Book> getFavouriteBooks() {
        return this.favouriteBooks;
    }
    //    public void addBook(Book book) {
//        this.books.add(book);
//    }
//    public void removeBook(Book book) {
//        this.books.remove(book);
//    }
}