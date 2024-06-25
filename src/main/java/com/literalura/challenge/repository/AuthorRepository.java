package com.literalura.challenge.repository;

import com.literalura.challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(Integer year, Integer year2);

}
