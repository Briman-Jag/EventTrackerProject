package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.MusicFestival;

public interface MusicFestivalService {
	
	List<MusicFestival> listAllMusicFests();
	MusicFestival getMusicFest(int id);
	MusicFestival addMusicFest(MusicFestival musicFest);
	MusicFestival updateMusicFest(int id, MusicFestival musicFest);
	boolean deleteMusicFest(int id);
	

}
