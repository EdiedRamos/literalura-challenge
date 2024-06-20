package com.literalura.challenge.service;

import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.BookData;

public class BookService {

    private final GutendexRequest gutendexRequest;

    public BookService() {
        gutendexRequest = new GutendexRequest();
    }

    public BookData searchBookByTitle(String bookTitle) {
        JSONConverter jsonConverter = new JSONConverter();
        String resultJson = gutendexRequest.searchByTitle(bookTitle);
        return jsonConverter.toObjectWithBuilder(resultJson, BookData.class, new BookDeserializer());
    }

}
