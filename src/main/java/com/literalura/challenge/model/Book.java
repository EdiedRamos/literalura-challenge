package com.literalura.challenge.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String language;
    @SerializedName("download_count")
    private int downloads;

    public Book() {}

    @Override
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nLanguage: %s\nDownloads: %d",
                title,
                author,
                language,
                downloads);
    }
}
