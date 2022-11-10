package com.greatlearning.debateRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.debateRegistration.entity.Role;
import com.greatlearning.debateRegistration.service.RoleService;


@Controller
@RequestMapping("/roles")
public class RolesController {
	@Autowired
	private RoleService roleService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listRoles(Model model) {

		// get Employees from DB
		List<Role> roles = roleService.findAll();

		// add to the spring model
		model.addAttribute("Roles", roles);

		return "list-roles";
	}
	
	@RequestMapping("/add")
	public String addRole(Model model) {

		// create model attribute to bind form data
		Role role = new Role();

		model.addAttribute("Role", role);

		return "add-role";
	}

	@PostMapping("/save")
	public String saveRole(@RequestParam("id") int id,
			@RequestParam("name") String name) {
		
		Role role = new Role(name);
		// save the Role
		roleService.save(role);

		// use a redirect to prevent duplicate submissions
		return "redirect:/roles/list";
	}
}
