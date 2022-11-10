package com.greatlearning.debateRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.greatlearning.debateRegistration.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstNameContainsAllIgnoreCase(String fName); 

}
