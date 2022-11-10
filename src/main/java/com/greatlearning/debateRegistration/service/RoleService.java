package com.greatlearning.debateRegistration.service;

import java.util.List;

import com.greatlearning.debateRegistration.entity.Role;

public interface RoleService {
public List<Role> findAll();
	
	public Role findById(int id);
	
	public void save (Role role);
}
