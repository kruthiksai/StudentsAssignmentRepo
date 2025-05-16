package com.project.books.service;

import com.project.books.entities.Users;
import com.project.books.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  UsersRepository usersRespository;

  public Users createUser(Users user) {
    Users save = usersRespository.save(user);
    return save;
  }

  public Users login(String email, String password) {
    Users save = usersRespository.findUsersByEmailAndAndPassword(email,password);
    return save;
  }
}
