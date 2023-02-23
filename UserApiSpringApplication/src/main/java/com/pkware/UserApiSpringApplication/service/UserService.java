package com.pkware.UserApiSpringApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkware.UserApiSpringApplication.model.User;
import com.pkware.UserApiSpringApplication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Object createUser(User reqData) {
		return userRepository.save(reqData);
	}

	public Object getAllUsers() {
		return userRepository.findAll();
	}

	public User ifUserExist(User reqData) {
		return userRepository.findByName(reqData.getName());
	}

	public Object getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Object updateUser(User newUser, User oldUser) {
		oldUser.setName(newUser.getName());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setMobNo(newUser.getMobNo());
		oldUser.setPassword(newUser.getPassword());

		return userRepository.save(oldUser);
	}

	public Object deleteUserById(Long id) {
		userRepository.deleteById(id);
		return null;
	}
}
