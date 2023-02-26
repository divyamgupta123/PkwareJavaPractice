package com.pkware.UserApiSpringApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkware.UserApiSpringApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByPassword(String password);
}
