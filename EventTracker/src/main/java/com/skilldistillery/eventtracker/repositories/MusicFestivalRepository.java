package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.MusicFestival;

public interface MusicFestivalRepository extends JpaRepository<MusicFestival, Integer>{
	
	
	
	List<MusicFestival> findByNumOfDays(int numOfDays);
	
	List<MusicFestivalRepository> findByNameContains(String keyword);
	
	List<MusicFestivalRepository> findByHeadliners(String headliners);
	
	List<MusicFestivalRepository> findByMusicGenre(String genre);

	List<MusicFestivalRepository> findByTicketPrice(double low, double high);
	


}
