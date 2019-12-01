package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicFestivalTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private MusicFestival musicFest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MusicFestivalPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		musicFest = em.find(MusicFestival.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		musicFest = null;
	}

	@Test
	void test_Post_entity_mapping() {
		assertNotNull(musicFest);
		assertEquals("Sunset Music Festival", musicFest.getName());
	}
	
	@Test
	void test_Post_entity_mapping_Date() {
		assertNotNull(musicFest);
		assertEquals("2015-05-23", musicFest.getStartDate().toString());
	}

}
