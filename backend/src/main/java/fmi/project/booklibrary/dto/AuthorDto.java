package fmi.project.booklibrary.dto;

import fmi.project.booklibrary.model.Book;
import java.util.Set;

public class AuthorDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String description;

    private Set<Book> books;

    public AuthorDto(Long id, String firstName, String lastName, String description, Set<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.books = books;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() { return this.books; }
}
