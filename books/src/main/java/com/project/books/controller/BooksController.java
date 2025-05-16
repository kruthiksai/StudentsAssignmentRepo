package com.project.books.controller;

import com.project.books.entities.Books;
import com.project.books.entities.Users;
import com.project.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

  @Autowired
  BooksService booksService;

  @GetMapping("/showBooks")
  public ResponseEntity<List<Books>> showList() {
    List<Books> books = booksService.getAllBooks();
    return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
  }

  @GetMapping("/getbook/{id}")
  public ResponseEntity<Books> showList(@PathVariable Long id) {
    Books books = booksService.findBookById(id);
    return new ResponseEntity<Books>(books, HttpStatus.OK);
  }

  @GetMapping("/getlatestbooks")
  public ResponseEntity<List<Books>> latestBooks() {
    List<Books> books = booksService.getLatestBooks();
    return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
  }
}
