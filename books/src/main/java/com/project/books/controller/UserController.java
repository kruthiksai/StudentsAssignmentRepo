package com.project.books.controller;

import com.project.books.DTO.UserDTO;
import com.project.books.entities.Users;
import com.project.books.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UsersService usersService;

  @CrossOrigin
  @ResponseBody
  @PostMapping("/register")
  public ResponseEntity<Users> createUser(@RequestBody Users users) {
    System.out.println(users);
    Users save = usersService.createUser(users);
    return new ResponseEntity<Users>(save, HttpStatus.OK);
  }

  @CrossOrigin
  @ResponseBody
  @PostMapping("/login")
  public ResponseEntity<Users> login(@RequestBody UserDTO userDTO) {
    Users user = usersService.login(userDTO.getEmail(),userDTO.getPassword());
    if(user!=null){
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
  }
}
