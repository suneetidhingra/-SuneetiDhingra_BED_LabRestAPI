package com.greatlearning.debateRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.User;
import com.greatlearning.debateRegistration.repository.UserRepository;
import com.greatlearning.debateRegistration.security.MyUserDetails;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("could not find user with given name");
		}
		return new MyUserDetails(user);
	}
}
