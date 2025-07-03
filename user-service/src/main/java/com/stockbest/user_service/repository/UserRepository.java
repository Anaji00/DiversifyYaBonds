package com.stockbest.user_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;  // import the User entity

import com.stockbest.user_service.model.User; // import JPA repo

// this interface extends JpaRepository, giving us CRUD methods for User automatically
public interface UserRepository extends JpaRepository<User, Long> {
    // by extending JpaRepository<User, Long>, Spring will create
    // findAll(), save(), deleteById(), etc, for User with Long primary key
}