package com.literalura.challenge.repository;

import com.literalura.challenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
