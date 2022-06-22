package fmi.project.booklibrary.dto;

import fmi.project.booklibrary.model.Author;
import fmi.project.booklibrary.model.enums.CoverType;
import fmi.project.booklibrary.model.enums.Genre;

import java.util.Set;

public class BookDto {
    private Long id;
    private String title;
    private Set<Author> authors;
    private String description;
    private Double price;
    private Integer pages;
    private CoverType coverType;
    private Genre genre;

    public BookDto(Long id, String title, Set<Author> authors, String description, Double price, Integer pages, CoverType coverType, Genre genre) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
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
