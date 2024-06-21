package com.literalura.challenge.repository;

import com.literalura.challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
