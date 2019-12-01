package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.eventtracker.entities.MusicFestival;

public interface MusicFestivalRepository extends JpaRepository<MusicFestival, Integer>{
	
	List<MusicFestival> findByNumOfDays(int numOfDays);
	
	List<MusicFestival> findByNameContains(String keyword);
	
	List<MusicFestival> findByHeadliners(String headliners);
	
	List<MusicFestival> findByMusicGenre(String genre);
	
	@Query("SELECT m from MusicFestival m WHERE m.ticketPrice BETWEEN :lowest AND :highest ")
	List<MusicFestival> queryByTicketPriceInRange(@Param("lowest")double low,@Param("highest") double high);
	
	
}
