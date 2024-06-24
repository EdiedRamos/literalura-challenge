package com.literalura.challenge.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorDTO {
    private String name;
    @SerializedName("birth_year")
    private Integer birthYear;
    @SerializedName("death_year")
    private Integer deathYear;
}
