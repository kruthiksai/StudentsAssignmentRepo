package com.project.books.service;

import com.project.books.entities.Books;
import com.project.books.repository.BooksRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

  @Autowired
  BooksRespository booksRespository;
  public List<Books> getAllBooks() {
    List<Books> list = booksRespository.findAll();
    return list;
  }

  public Books findBookById(Long id) {
    Books book = booksRespository.findById(id).get();
    return book;
  }

  public List<Books> getLatestBooks() {
    List<Books> list = booksRespository.findTop10ByOrderByCreatedAtDesc();
    return list;
  }
}
