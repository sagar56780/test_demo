package edu.qs.Employee.model.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.qs.Employee.entity.Student;
import edu.qs.Employee.repository.StudentRepository;

@Component
public class StudentDao {
	@Autowired
	StudentRepository srepo;
	
	public Student getStudent(int id)
	{ 
	 Optional<Student> opt=	srepo.findById(id);
	 if(opt.isPresent())
	 {
		 return opt.get();
	 }
	 else {
		 return null;
	 }
		
	}
	public void saveStudent(Student s) {
		srepo.save(s);
		
	}
}
 