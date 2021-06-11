package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Game;
import com.example.demo.repo.GameRepo;

@Service
public class GameService {
	
	private GameRepo repo;
	
	public GameService(GameRepo repo) { 
		this.repo = repo;
	}
	
	public Game createvideoGames(Game g) {
		return this.repo.save(g);
	}
	
	public List<Game> getALLvideoGames(){
		return this.repo.findAll();
	}
	
	public Game getvideoGames(Long id) {
		Optional<Game> g = this.repo.findById(id);
		return g.get();
	}
	
	public Game updatevideoGames(Long id, Game newGame) {
		Game existing = this.getvideoGames(id);
		existing.setName(newGame.getName());
		existing.setRating(newGame.getRating());
		existing.setPrice(newGame.getPrice());
		
		Game updated = this.repo.save(existing);
		return updated;
	}
	

	public boolean removevideoGames(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	public Game getByName(String name) {
		return this.repo.findByName(name);
	}
}
