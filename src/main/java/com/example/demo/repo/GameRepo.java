package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Game;

@Repository
	public interface GameRepo extends JpaRepository<Game, Long>{
		
		@Query(value = "SELECT * FROM GAME WHERE name=?1", nativeQuery=true)
		Game findByName(String name);
	
	
	
	}


