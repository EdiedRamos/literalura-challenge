package com.literalura.challenge.controller;

import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.entity.Author;
import com.literalura.challenge.entity.Book;
import com.literalura.challenge.service.AuthorService;
import com.literalura.challenge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    public BookDTO searchBookByTitle(String bookTitle) {
        return bookService.searchBookByTitle(bookTitle);
    }

    public List<Book> listAllBooks() {
        return bookService.getAllBooks();
    }

    public List<Author> listAllAuthors() {
        return authorService.getAllAuthors();
    }
}
