package com.greatlearning.debateRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.Student;
import com.greatlearning.debateRegistration.repository.StudentRepository;



@Service
public  class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll(String sort) {
		if(sort.isEmpty()) {
			return studentRepository.findAll();
		}
		Direction direction = sort.equals("asc") ? Direction.ASC : Direction.DESC;
		return studentRepository.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void save(Student employee) {
		studentRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> searchBy(String firstName) {
		return studentRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

}
