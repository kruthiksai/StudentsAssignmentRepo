package com.project.books.controller;

import com.project.books.DTO.CartDto;
import com.project.books.entities.Books;
import com.project.books.entities.Cart;
import com.project.books.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

  @Autowired
  CartService cartService;

  @CrossOrigin
  @ResponseBody
  @PostMapping("/addtocart")
  public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
    Cart cart1 = cartService.addToCart(cart);
    return new ResponseEntity<Cart>(cart1, HttpStatus.OK);
  }

  @CrossOrigin
  @GetMapping("/getcart/{email}")
  public ResponseEntity<List<CartDto>> showList(@PathVariable String email) {
    List<CartDto> allCartItemsByEmail = cartService.getAllCartItemsByEmail(email);
    return new ResponseEntity<List<CartDto>>(allCartItemsByEmail, HttpStatus.OK);
  }
}
