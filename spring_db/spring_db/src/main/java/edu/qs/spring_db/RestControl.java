package edu.qs.spring_db;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.qs.spring_db.entity.Cricketer;
import edu.qs.spring_db.repository.CricketerRepository;
@RestController
@RequestMapping("/cricketer")
public class RestControl {
	@Autowired
	CricketerRepository repo;
	
//	@PostMapping("/cricketers")
//	public void setCricketer(@RequestBody Cricketer c) {
//		repo.save(c);
//	}
	@GetMapping("/{id}")
	public Cricketer getCricketer(@PathVariable int id)
	{

		
		Optional<Cricketer> cr= repo.findById(id);
		if(cr.isPresent())
		{
			return cr.get();
		}
		else
		{
			return null;
		}
		
	}
//	@PostMapping()
//	public void setMultipleCricketers(@RequestBody List<Cricketer> l)
//	{
//		repo.saveAll(l);
//		
//	}
//	@GetMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//	public List<Cricketer> getAllCricketers(){
//		return repo.findAll();
//	}
//	@GetMapping("/{id}")
//	public Cricketer getCricketer(@PathVariable int id) {
//		Optional<Cricketer> cric=repo.findById(id);
//		if(cric.isPresent())
//		{
//			return cric.get();
//		}
//		else {
//			return null;
//		}
//	}
//	@GetMapping("/{name}")
//	public Cricketer getByName(@PathVariable String name)
//	{
//		
//		return repo.findByName(name);
//	}
//	@GetMapping("/age/{age}")
//	public Cricketer getByAge(@PathVariable int age)
//	{
//		return repo.findByAge(age);
//		
//	}
//	@GetMapping("/team/{team}")
//	public Cricketer getByTeam(@PathVariable String team)
//	{
//		return repo.findByTeam(team);
//	}
//	@DeleteMapping("/{id}")
//	public String deleteCricketer(@PathVariable int id)
//	{
//		repo.deleteById(id);
//		return "success";
//	}
//	@DeleteMapping()
//	public String deleteAllCricketer()
//	{
//		repo.deleteAll();
//		return "succuss fully deleted";
//		
//	}
}