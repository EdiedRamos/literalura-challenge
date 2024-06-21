package com.literalura.challenge.service;

import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.BookDTO;

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

}
