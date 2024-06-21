package com.literalura.challenge.service;

import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.entity.Book;

public class BookService {

    private final GutendexRequest gutendexRequest;

    public BookService() {
        gutendexRequest = new GutendexRequest();
    }

    public BookDTO searchBookByTitle(String bookTitle) {
        JSONConverter jsonConverter = new JSONConverter();
        String resultJson = gutendexRequest.searchByTitle(bookTitle);
        return jsonConverter.toObjectWithBuilder(resultJson, BookDTO.class, new BookDeserializer());
    }

    //    TODO: This could be omitted with Mappers
    private Book fromBookDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setLanguage(bookDTO.getLanguage());
        book.setDownloads(bookDTO.getDownloads());
        return book;
    }

}
