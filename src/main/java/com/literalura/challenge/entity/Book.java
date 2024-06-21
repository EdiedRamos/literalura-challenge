package com.literalura.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String language;
    private Integer downloads;

    public Book() {
    }

    @Override
    public String toString() {
        return String.format("Id: %s\nTitle: %s\nAuthor: %s\nLanguage: %s\nDownloads: %d",
                id,
                title,
                author,
                language,
                downloads);
    }
}
