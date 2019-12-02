package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.skilldistillery.eventtracker.entities.MusicFestival;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFestivalRepositoryTest {
	@Autowired
	private MusicFestivalRepository repo;
	
	@Test
	void test_MusicFestivalRepository_findByHeadliners() {
		List<MusicFestival> musicFests = repo.findByHeadlinersIgnoreCase("ZHU, Miike Snow");
		assertEquals(1, musicFests.get(0).getId());
	}

}
