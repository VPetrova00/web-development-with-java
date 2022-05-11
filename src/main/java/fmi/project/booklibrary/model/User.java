package fmi.project.booklibrary.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private List<Book> allBooks;
    private List<Book> favouriteBooks;

    public User() {
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBooks(List<Book> books) {
        this.allBooks = books;
    }

    public int getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Book> getAllBooks() {
        return this.allBooks;
    }

    public void setFavouriteBooks(List<Book> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public List<Book> getFavouriteBooks() {
        return this.favouriteBooks;
    }
    //    public void addBook(Book book) {
//        this.books.add(book);
//    }
//    public void removeBook(Book book) {
//        this.books.remove(book);
//    }
}
