package fmi.project.booklibrary.dto;

import javax.validation.constraints.NotEmpty;

import fmi.project.booklibrary.model.Book;
import fmi.project.booklibrary.model.User;

import java.util.Set;

public class UserDTO {
    public Long id;

    @NotEmpty(message = "Not entered username")
    public String username;

    @NotEmpty(message = "Not entered password")
    public String password;

    @NotEmpty(message = "Email must be entered.")
    public String email;

    public Set<Book> allBooks;

    public Set<Book> favouriteBooks;

    public UserDTO(String password, String email, String username, Set<Book> books, Set<Book> favouriteBooks) {
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
        this.email = user.getEmail();
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
}
