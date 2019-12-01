package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.MusicFestival;
import com.skilldistillery.eventtracker.repositories.MusicFestivalRepository;

@Service
public class MusicFestivalServiceImpl implements MusicFestivalService{
	
	@Autowired
	private MusicFestivalRepository repo;

	@Override
	public List<MusicFestival> listAllMusicFests() {
		return repo.findAll();
	}

	@Override
	public MusicFestival getMusicFest(int id) {
		MusicFestival musicFest = null;
		Optional<MusicFestival> opt = repo.findById(id);
		if(opt.isPresent()) {
			musicFest = opt.get();
		}
		return musicFest;
	}

	@Override
	public MusicFestival addMusicFest(MusicFestival musicFest) {
		repo.saveAndFlush(musicFest);
		return musicFest;
	}

	@Override
	public MusicFestival updateMusicFest(int id, MusicFestival musicFest) {
		MusicFestival existing = null;
		Optional<MusicFestival> opt = repo.findById(id);
		if(opt.isPresent()) {
			existing = opt.get();
			existing.setName(musicFest.getName());
			existing.setLocation(musicFest.getLocation());
			existing.setNumOfDays(musicFest.getNumOfDays());
			existing.setStartDate(musicFest.getStartDate());
			existing.setEndDate(musicFest.getEndDate());
			existing.setMusicGenre(musicFest.getMusicGenre());
			existing.setHeadliners(musicFest.getHeadliners());
			existing.setArtistsSeen(musicFest.getArtistsSeen());
			existing.setTicketPrice(musicFest.getTicketPrice());
			repo.saveAndFlush(existing);
		} else {
			return null;
		}
		return existing;
	}

	@Override
	public boolean deleteMusicFest(int id) {
		boolean successful = true;
		if (!repo.existsById(id)) {
			return false;
		} else {
			repo.deleteById(id);
			return successful;
		}
	}

}
