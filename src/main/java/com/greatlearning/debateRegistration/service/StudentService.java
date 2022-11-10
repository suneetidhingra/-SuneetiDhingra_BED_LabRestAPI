package com.greatlearning.debateRegistration.service;

import java.util.List;

import com.greatlearning.debateRegistration.entity.Student;

public interface StudentService {
public List<Student> findAll(String sort);
	
	public Student findById(int id);
	
	public void save (Student student);
	
	public void deleteById(int id);
	
	public List<Student> searchBy(String firstName);
}
