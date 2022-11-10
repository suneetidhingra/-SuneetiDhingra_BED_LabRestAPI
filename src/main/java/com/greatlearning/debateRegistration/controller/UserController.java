package com.greatlearning.debateRegistration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.debateRegistration.entity.Role;
import com.greatlearning.debateRegistration.entity.User;
import com.greatlearning.debateRegistration.service.RoleService;
import com.greatlearning.debateRegistration.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/add")
	public String addUser(Model model) {

		// create model attribute to bind form data
		User user = new User();

		model.addAttribute("User", user);

		return "add-user";
	}

	@PostMapping("/save")
	public String saveUser(@RequestParam("id") long id,
			@RequestParam("username") String userName,
			@RequestParam("password") String password,
			@RequestParam("role_ids") String roleIds) {

		String encodedPassword = passwordEncoder.encode(password);
//		System.out.println(String.format("%s, %s, %s", userName, encodedPassword, roleIds));
		List<Role> roles = new ArrayList<>();
		String[] roleIdList = roleIds.split(",");
		for (String roleId : roleIdList) {
			Role role = roleService.findById(Integer.parseInt(roleId.trim()));
//			System.out.println(role.getName());
			roles.add(role);
		}
		
		User user = new User(userName, encodedPassword, roles);
		// save the Role
		userService.save(user);

		// use a redirect to prevent duplicate submissions
		return "redirect:/login";
	}
}
