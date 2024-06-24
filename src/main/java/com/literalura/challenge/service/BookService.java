package com.literalura.challenge.service;

import com.literalura.challenge.deserialization.AuthorDeserializer;
import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.AuthorDTO;
import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.entity.Book;
import com.literalura.challenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final GutendexRequest gutendexRequest;
    @Autowired
    BookRepository bookRepository;

    public BookService() {
        gutendexRequest = new GutendexRequest();
    }

    public BookDTO searchBookByTitle(String bookTitle) {
        JSONConverter jsonConverter = new JSONConverter();
        String resultJson = gutendexRequest.searchByTitle(bookTitle);
        BookDTO bookDTO = jsonConverter.toObjectWithBuilder(resultJson, BookDTO.class, new BookDeserializer());
        AuthorDTO authorDTO = jsonConverter.toObjectWithBuilder(resultJson, AuthorDTO.class, new AuthorDeserializer());
        System.out.println(authorDTO);
        Book book = fromBookDTO(bookDTO);
        bookRepository.save(book);
        return bookDTO;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //    TODO: This could be omitted with Mappers
    private Book fromBookDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setLanguage(bookDTO.getLanguage());
        book.setDownloads(bookDTO.getDownloads());
        return book;
    }

}
