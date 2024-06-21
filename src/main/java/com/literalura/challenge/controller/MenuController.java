package com.literalura.challenge.controller;

import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.service.BookService;

public class MenuController {
    private final BookService bookService;

    public MenuController(BookService bookService) {
        this.bookService = bookService;
    }

    public BookDTO searchBookByTitle(String bookTitle) {
        return bookService.searchBookByTitle(bookTitle);
    }
}
