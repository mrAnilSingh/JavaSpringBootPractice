package com.example.userservice.controller;

import java.util.List;

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

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id){
		UserDto user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable int id, 
												 @RequestBody UserDto user){
		user.setId(id);
		UserDto updatedUser  = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
	}
	
}
