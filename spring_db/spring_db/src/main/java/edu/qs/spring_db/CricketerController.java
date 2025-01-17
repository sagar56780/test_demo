package edu.qs.spring_db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.qs.spring_db.entity.Cricketer;
import edu.qs.spring_db.repository.CricketerRepository;

@RestController

public class CricketerController {
	@Autowired
	CricketerRepository repo;
	
	@GetMapping(value="/consume/{id}" ,consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Cricketer getCricketer(@PathVariable int id) {	
		Optional<Cricketer> cric=repo.findById(id);
		if(cric.isPresent())
		{
			return cric.get();
		}
		else {
			return null;
		}
	}
	

}
