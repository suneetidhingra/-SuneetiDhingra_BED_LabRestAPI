package com.greatlearning.debateRegistration.controller;

import java.security.Principal;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.greatlearning.debateRegistration.entity.Student;
import com.greatlearning.debateRegistration.service.StudentService;

@Controller
@RequestMapping("students")
public class StudentsController {
	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/add")
	public String  add(Model model) {
		//create model attribute to bind  form data
		
		Student student = new Student();
		model.addAttribute("Student", student);
		return "update-student";
			
	}
	
	@RequestMapping("/list")
	public String listStudents(@RequestParam(defaultValue = "") String sort, Model model) {

		// get Employees from DB
		List<Student> students = studentService.findAll(sort);
		
		// add to the spring model
		model.addAttribute("Students",students );

		return "list-students";
	}
	
	@RequestMapping("/view")
	public String view(@RequestParam("studentId") int id, Model model) {

		// get the Employee from the service
		Student student = studentService.findById(id);

		// set Employee as a model attribute to view on the page
		model.addAttribute("Student", student);

		// send over to our page
		return "view-student";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("studentId") int id, Model model) {

		// get the Employee from the service
		Student student = studentService.findById(id);

		// set Employee as a model attribute to pre-populate the form
		model.addAttribute("Student", student);

		// send over to our form
		return "update-student";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country ){

		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else
			student = new Student(firstName, lastName, course, country );
		// save the Employee
		studentService.save(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {

		// delete the Employee
		studentService.deleteById(id);

		// redirect to /employees/list
		return "redirect:/students/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("firstName") String firstName, Model model) {

		// check names, if both are empty then just give list of all Employees

		if (firstName.trim().isEmpty()) {
			return "redirect:/students/list";
		}
		// else, search by first name
		List<Student> students = studentService.searchBy(firstName);

		// add to the spring model
		model.addAttribute("Students", students);

		// send to list-employees
		return "list-students";
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView modelAndView = new ModelAndView();

		if (user != null) {
			modelAndView.addObject("msg", "Hi " + user.getName() + ", you don't have permission to access this page!");
		} else {
			modelAndView.addObject("msg", "You don't have permission to access this page!");
		}
		modelAndView.setViewName("403");
		return modelAndView;
	}
}
