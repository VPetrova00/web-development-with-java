package fmi.project.booklibrary.model;

import fmi.project.booklibrary.model.enums.CoverType;
import fmi.project.booklibrary.model.enums.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Author> authors;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Integer pages;

    @Column
    private CoverType coverType;

    @Column
    private Genre genre;

    public Book() {
        this.title = null;
        this.authors = new HashSet<>();
        this.description = null;
        this.price = 0.0;
        this.pages = 0;
        this.coverType = CoverType.HARD;
        this.genre = Genre.OTHER;
    }

    public Book(String title, Set<Author> authors, Double price, Integer pages, CoverType coverType, Genre genre) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.pages = pages;
        this.coverType = coverType;
        this.genre = genre;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public CoverType getCoverType() {
        return this.coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
