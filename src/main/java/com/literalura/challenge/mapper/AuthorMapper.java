package com.literalura.challenge.mapper;

import com.literalura.challenge.dto.AuthorDTO;
import com.literalura.challenge.entity.Author;

public class AuthorMapper {

    public static Author fromAuthorDTO(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setBirthYear(authorDTO.getBirthYear());
        author.setDeathYear(authorDTO.getDeathYear());
        return author;
    }

}
