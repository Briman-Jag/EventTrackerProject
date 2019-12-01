package com.skilldistillery.eventtracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.MusicFestival;
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
	
	@GetMapping("musicfestivals")
	public List<MusicFestival> listMusicFestivals() {
		return svc.listAllMusicFests();
	}
	
	@GetMapping("musicfestivals/{musicFestId}")
	public MusicFestival getMusicFestival(@PathVariable Integer musicFestId, HttpServletResponse resp) {
		return svc.getMusicFest(musicFestId);
	}
	
	

}
