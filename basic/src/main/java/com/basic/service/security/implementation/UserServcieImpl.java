package com.basic.service.security.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.persitance.model.security.User;
import com.basic.persitance.repository.security.UserRepo;
import com.basic.service.security.UserService;
@Service
public class UserServcieImpl implements UserService{
	private UserRepo userRepo;
	@Autowired
	public UserServcieImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	@Override
	public String save(User user) {
		userRepo.save(user);
		return "User Created";
	}
	
}
