package com.maids.cc.bookStore.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOK")
public class Book {
    @Id
    private Integer id;
    private String title;
    private String author;
    private String publicationYear;
    private String isbn;


    private Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
