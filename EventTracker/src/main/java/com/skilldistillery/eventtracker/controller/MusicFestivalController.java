package com.skilldistillery.eventtracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.MusicFestival;
import com.skilldistillery.eventtracker.repositories.MusicFestivalRepository;
import com.skilldistillery.eventtracker.services.MusicFestivalService;

@RestController
@RequestMapping("api")
public class MusicFestivalController {
	
	@Autowired
	private MusicFestivalService svc;
	@Autowired
	private MusicFestivalRepository repo;
	
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
		MusicFestival musicFest = svc.getMusicFest(musicFestId);
		if(musicFest == null) {
			resp.setStatus(404);
		}
		return musicFest;
	}
	
	@PostMapping("musicfestivals")
	public MusicFestival createMusicFestival(@RequestBody MusicFestival musicFest, HttpServletRequest req, HttpServletResponse resp) {
		try {
			svc.addMusicFest(musicFest);

			resp.setStatus(201);

			StringBuffer url = req.getRequestURL();
			url.append("/").append(musicFest.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}

		return musicFest;
	}
	
	@PutMapping("musicfestivals/{musicFestId}")
	public MusicFestival updateMusicFest(@PathVariable Integer musicFestId, @RequestBody MusicFestival musicFest, HttpServletResponse resp) {
		try {
			svc.updateMusicFest(musicFestId, musicFest);
			if (musicFest == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		return musicFest;
	}

	@DeleteMapping("musicfestivals/{postId}")
	public void deletePost(@PathVariable("postId") Integer musicFestId , HttpServletResponse resp ){
		try {
			boolean deleted = svc.deleteMusicFest(musicFestId);
			 if(deleted) {
				 resp.setStatus(204);
			 }
			 else {
				 resp.setStatus(404);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
	}
	
	@GetMapping("musicfestivals/search/{keyword}")
	public List<MusicFestival> findPostByKeyword(@PathVariable String keyword, HttpServletResponse resp) {
		List<MusicFestival> posts = repo.findByNameContains(keyword);
		if (posts == null) {
			resp.setStatus(404);
		}
		return posts;
	}
	
	@GetMapping("posts/search/price/{low}/{high}")
	public List<MusicFestival> findByPriceRange(@PathVariable double low, @PathVariable double high, HttpServletResponse resp) {
		List<MusicFestival> posts = repo.queryByTicketPriceInRange(low, high);
		if (posts == null) {
			resp.setStatus(404);
		}
		return posts;
	}
	
	
	
}
