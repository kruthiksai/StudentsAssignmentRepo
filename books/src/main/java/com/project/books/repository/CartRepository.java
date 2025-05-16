package com.project.books.repository;

import com.project.books.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

  List<Cart> findAllByUserEmail(String userEmail);

  Integer deleteCartByBookIdAndUserEmail(Long bookId, String userEmail);
}
