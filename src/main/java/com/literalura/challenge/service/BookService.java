package com.literalura.challenge.service;

import com.literalura.challenge.deserialization.AuthorDeserializer;
import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.AuthorDTO;
import com.literalura.challenge.dto.BookDTO;
import com.literalura.challenge.entity.Author;
import com.literalura.challenge.entity.Book;
import com.literalura.challenge.mapper.AuthorMapper;
import com.literalura.challenge.mapper.BookMapper;
import com.literalura.challenge.repository.AuthorRepository;
import com.literalura.challenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final GutendexRequest gutendexRequest;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;


    public BookService() {
        gutendexRequest = new GutendexRequest();
    }

    public BookDTO searchBookByTitle(String bookTitle) {
        JSONConverter jsonConverter = new JSONConverter();
        String resultJson = gutendexRequest.searchByTitle(bookTitle);
        BookDTO bookDTO = jsonConverter.toObjectWithBuilder(resultJson, BookDTO.class, new BookDeserializer());
        AuthorDTO authorDTO = jsonConverter.toObjectWithBuilder(resultJson, AuthorDTO.class, new AuthorDeserializer());
        Book book = BookMapper.fromBookDTO(bookDTO);
        Author author = AuthorMapper.fromAuthorDTO(authorDTO);
        authorRepository.save(author);
        book.setAuthor(author);
        bookRepository.save(book);
        return bookDTO;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
