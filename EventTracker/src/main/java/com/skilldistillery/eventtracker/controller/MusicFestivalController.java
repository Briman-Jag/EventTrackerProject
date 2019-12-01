package com.skilldistillery.eventtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.services.MusicFestivalService;

@RestController
@RequestMapping("api")
public class MusicFestivalController {
	
	@Autowired
	private MusicFestivalService svc;
	
	@GetMapping("ping")
	public String ping() {
		return "pooooooong";
	}
	
	

}
