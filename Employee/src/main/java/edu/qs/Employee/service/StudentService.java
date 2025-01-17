package edu.qs.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.Employee.entity.Student;
import edu.qs.Employee.model.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	StudentDao sdao;
	
	public Student getStudent(int id) {
		return sdao.getStudent(id);
	}
	
	public boolean saveStudent(Student s)
	{
		sdao.saveStudent(s);
		if(sdao.getStudent(s.getId())!=null)
		{
			
			return true;
			
		}
		else {
			return false;
		}
	}
	
	
	

}

