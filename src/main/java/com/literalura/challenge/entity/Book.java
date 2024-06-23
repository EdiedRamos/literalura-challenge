package com.literalura.challenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String language;
    private Integer downloads;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorInfo;

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
