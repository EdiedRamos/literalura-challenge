package com.literalura.challenge.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDTO {
    private String title;
    private String language;
    @SerializedName("download_count")
    private int downloads;

    public BookDTO() {}

    @Override
    public String toString() {
        return String.format("Title: %s\nLanguage: %s\nDownloads: %d",
                title,
                language,
                downloads);
    }
}
