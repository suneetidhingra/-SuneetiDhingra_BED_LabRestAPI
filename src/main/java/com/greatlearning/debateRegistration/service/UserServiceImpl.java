package com.greatlearning.debateRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.User;
import com.greatlearning.debateRegistration.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}
}
