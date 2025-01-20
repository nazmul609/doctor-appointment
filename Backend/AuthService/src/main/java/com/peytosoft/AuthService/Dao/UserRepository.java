package com.peytosoft.AuthService.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peytosoft.AuthService.Model.User;



public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByEmail(String email);
}
