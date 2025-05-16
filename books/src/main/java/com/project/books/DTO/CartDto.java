package com.project.books.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {

  private Long id;

  private Long quantity;

  private Long bookId;

  private String imgUrl;

  private String name;

  private Double price;

}
