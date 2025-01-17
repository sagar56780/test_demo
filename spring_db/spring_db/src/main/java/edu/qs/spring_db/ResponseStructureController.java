package edu.qs.spring_db;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import edu.qs.spring_db.entity.Cricketer;
import edu.qs.spring_db.repository.CricketerRepository;
import edu.qs.spring_db.response_structure.ResponseStructure;

@RestController	
public class ResponseStructureController {
	@Autowired
	CricketerRepository repo;
	
	@GetMapping("/get_cricketer/{id}")
	public ResponseStructure<Cricketer> getStudentData(@PathVariable int id)
	{
		Optional<Cricketer> op=repo.findById(id);
		ResponseStructure<Cricketer> rs=new ResponseStructure<>();
		if(op.isPresent())
		{
			rs.setData(op.get());
			rs.setStatus(200);
			rs.setMessage("data found successfully");
			return rs;
		}
		else {
			rs.setStatus(404);
			rs.setMessage("data not present");
			rs.setData(null);
			return rs;
		}
	}
	@GetMapping("/get_cricketer_data/{id}")
	public ResponseEntity<ResponseStructure<Cricketer>> getCricketer(@PathVariable int id){
		
		ResponseStructure<Cricketer> rs=new ResponseStructure<Cricketer>();
		Optional<Cricketer> op=repo.findById(id);
		if(op.isPresent())
		{
			rs.setStatus(200);
			
			rs.setData(op.get());
			HttpHeaders hh=new HttpHeaders();
			hh.add("port","192.168.1.201");
			
			return new ResponseEntity<ResponseStructure<Cricketer>>(rs, hh,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<ResponseStructure<Cricketer>>(rs, HttpStatus.NOT_FOUND);
		}
		
		
	}

}
