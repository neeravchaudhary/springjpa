package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springmvcboot.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	@GetMapping("aliens")
	public List<Alien> getAliens() {

		List<Alien> a = repo.findAll();
		return a;

	}

	@PostMapping(path="alien")
	public Alien addAlien(@RequestBody Alien a) {

		repo.save(a);
		return a;
	}

}
