package com.literalura.challenge.controller;

import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuController {

    @Autowired
    private BookService bookService;


    public BookDTO searchBookByTitle(String bookTitle) {
        return bookService.searchBookByTitle(bookTitle);
    }
}
