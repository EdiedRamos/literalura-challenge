package com.literalura.challenge.service;

import com.literalura.challenge.entity.Author;
import com.literalura.challenge.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAliveInYear(Integer year) {
        var authors = authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
        if (authors.isEmpty()) {
            throw new RuntimeException(new Exception("Autores no encontrados"));
        }
        return authors;
    }
}
