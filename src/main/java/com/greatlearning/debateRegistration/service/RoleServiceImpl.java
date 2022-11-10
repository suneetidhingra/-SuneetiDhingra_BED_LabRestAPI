package com.greatlearning.debateRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.Role;
import com.greatlearning.debateRegistration.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

}
