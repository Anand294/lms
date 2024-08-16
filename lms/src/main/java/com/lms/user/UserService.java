package com.lms.user;

import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.book.BookMaster;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserMaster addUser(UserMaster user) {
		return userRepository.save(user);
	}
	public Optional<UserMaster>getUserById(int userId){
		return userRepository.findById(userId);
	}
	
	public Iterable<UserMaster> getAllUsers(){
		return userRepository.findAll();
	}
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

}
