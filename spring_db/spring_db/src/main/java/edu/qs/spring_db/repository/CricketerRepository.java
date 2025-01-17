package edu.qs.spring_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.qs.spring_db.entity.Cricketer;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer>{
	Cricketer findByName(String  name);
	Cricketer findByAge(int age);
	Cricketer findByTeam(String team);

}
