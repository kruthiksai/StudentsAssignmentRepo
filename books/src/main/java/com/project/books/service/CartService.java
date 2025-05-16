package com.project.books.service;

import com.project.books.DTO.CartDto;
import com.project.books.entities.Books;
import com.project.books.entities.Cart;
import com.project.books.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
  @Autowired
  CartRepository cartRepository;

  @Autowired
  BooksService booksService;

  @Transactional
  public Cart addToCart(Cart cart){
    deleteCartByIDAndEmail(cart.getBookId(), cart.getUserEmail());
    Cart save = cartRepository.save(cart);
    return save;
  }


  public void deleteCartByIDAndEmail(Long bookId, String email){
    System.out.println(email);
    System.out.println(bookId);
    cartRepository.deleteCartByBookIdAndUserEmail(bookId, email);
  }

  public List<CartDto> getAllCartItemsByEmail(String email){
    List<Cart> allByUserEmail = cartRepository.findAllByUserEmail(email);
    List<CartDto> cartDtos = new ArrayList<>();
    for (Cart cart:allByUserEmail
         ) {
      Books bookById = booksService.findBookById(cart.getBookId());
      cartDtos.add(new CartDto(cart.getId(),cart.getQuantity(),cart.getBookId(),bookById.getImgUrl(), bookById.getName(), bookById.getPrice()));
    }
    return cartDtos;
  }
}
