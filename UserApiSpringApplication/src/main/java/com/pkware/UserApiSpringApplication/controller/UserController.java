package com.pkware.UserApiSpringApplication.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkware.UserApiSpringApplication.bean.BeanValidator;
import com.pkware.UserApiSpringApplication.bean.ResultDTO;
import com.pkware.UserApiSpringApplication.model.User;
import com.pkware.UserApiSpringApplication.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private BeanValidator beanValidator;

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody User reqData) {
		System.out.println(" --------- UserController.createUser ---------");
		ResultDTO<?> responsePacket = null;

		try {
			ArrayList<String> errorList = beanValidator.userValidate(reqData);
			if (errorList.size() != 0) {
				ResultDTO<ArrayList<String>> errorPacket = new ResultDTO<>(errorList,
						"Above fields values must not be empty", false);
				return new ResponseEntity<>(errorPacket, HttpStatus.BAD_REQUEST);
			}
			User isData = userService.ifUserExist(reqData);
			if (isData == null) {
				responsePacket = new ResultDTO<>(userService.createUser(reqData), "User Created Successfully", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>("User already exists", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> allUsers() {
		System.out.println(" ---------------- UserController.allUsers --------- ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.getAllUsers(), "Users fetched successfully!!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
		System.out.println(" ---------------- UserController.getUserById --------- ");
		ResultDTO<?> responsePacket = null;
		try {

			Object user = userService.getUserById(id);
			System.out.println(user);
			if (user == Optional.empty()) {
				responsePacket = new ResultDTO<>("User do not exist !!", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);

			} else {
				responsePacket = new ResultDTO<>(userService.getUserById(id), "User fetched successfully!!", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}

		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User newUser) {
		System.out.println(" --------- UserController.updateUser ---------");
		ResultDTO<?> responsePacket = null;

		try {
			User oldUser = userService.ifUserExist(newUser);
			if (oldUser != null) {
				responsePacket = new ResultDTO<>(userService.updateUser(newUser, oldUser), "User updated successfully",
						true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>("User do not exist", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		System.out.println(" ---------------- UserController.deleteUser --------- ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.deleteUserById(id), "User deleted successfully!!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
}
