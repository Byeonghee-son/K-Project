package com.airport.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.domain.User;
import com.airport.persistence.UserRepo;

@Service
public class UserServiceImpl {
	
	@Autowired
	public UserRepo userRepo;
	
	public User getUser(User user) {
		Optional<User> findUser = userRepo.findById(user.getId());
		if(findUser.isPresent())
			return findUser.get();
		else
			return null;
		
	}

}
