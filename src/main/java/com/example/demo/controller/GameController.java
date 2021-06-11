package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Game;

@RestController
public class GameController {

	private List<Game> videoGames = new ArrayList<>(); 

	@PostMapping("/create")
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		this.videoGames.add(game);
		Game added = this.videoGames.get(this.videoGames.size() - 1);
		return new ResponseEntity<Game>(added, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Game>> getvideoGames() {
		return new ResponseEntity<List<Game>>(this.videoGames, HttpStatus.OK);

	}

	@PutMapping("/put/{index}")
	public ResponseEntity<Game> updateVideoGames(@PathVariable int index, @RequestBody Game newGame) {
		this.videoGames.set(index, newGame);
		return new ResponseEntity<Game>(newGame, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{index}")
	public Game removevideoGames(@PathVariable int index) {
		return this.videoGames.remove(index);
	}
	
	@PatchMapping("/update/{index}")
	public ResponseEntity<Game> changeAttribute(@PathParam("name") String name, @PathParam("rating") String rating, @PathParam("price") Long Price, @PathVariable int index){
		Game updatevideoGames = this.videoGames.get(index);
		return new ResponseEntity<Game>(updatevideoGames, HttpStatus.ACCEPTED);
	}

}
