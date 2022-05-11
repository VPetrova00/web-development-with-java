package fmi.project.booklibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;

    private String title;

    private List<String> authors;

    private String description;

    private Double price;

    private Integer pages;

    private CoverType coverType;

    private String genre;

    public Book() {
        this.title = null;
        this.authors = new ArrayList<>();
        this.description = null;
        this.price = 0.0;
        this.pages = 0;
        this.coverType = CoverType.HARD;
        this.genre = null;
    }

    public Book(String title, List<String> authors, Double price, Integer pages, CoverType coverType, String genre) {
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

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
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

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
