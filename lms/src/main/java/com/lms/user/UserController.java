package com.lms.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserMaster saveUser(@ModelAttribute UserMaster user) {
	return userService.addUser(user);	
	}
	
	@GetMapping("/{userId}")
	public Optional<UserMaster>getUserById(@PathVariable("userId")int userId){
		return userService.getUserById(userId);
	}
	@GetMapping("/all")
	public Iterable<UserMaster> getallUsers(){
		return userService.getAllUsers();
	}
	

}
