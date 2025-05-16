package com.project.books.repository;

import com.project.books.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
  Users findUsersByEmailAndAndPassword(String email, String password);
}
