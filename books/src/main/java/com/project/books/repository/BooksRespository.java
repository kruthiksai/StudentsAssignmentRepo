package com.project.books.repository;

import com.project.books.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRespository extends JpaRepository<Books, Long> {

  List<Books> findTop10ByOrderByCreatedAtDesc();

}
