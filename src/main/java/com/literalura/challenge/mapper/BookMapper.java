package com.literalura.challenge.mapper;

import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.entity.Book;

public class BookMapper {

    public static Book fromBookDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setLanguage(bookDTO.getLanguage());
        book.setDownloads(bookDTO.getDownloads());
        return book;
    }

}
