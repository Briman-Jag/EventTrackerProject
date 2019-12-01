package com.skilldistillery.eventtracker.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.eventtracker.entities.MusicFestival;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class EventTrackerWebIntegrationTest {
	private String baseUrl = "http://localhost:8087/";

	  @Test
	  public void testListAllMusicFEstivals() throws IOException{
	    // configure TestRestTemplate to git our film index route
	    TestRestTemplate restTest = new TestRestTemplate();
	    ResponseEntity<String> response = restTest.getForEntity(baseUrl + "api/musicfestivals", String.class);

	    assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));

	    ObjectMapper mapper = new ObjectMapper();

	    // map to a JsonNode
	    JsonNode responseJson = mapper.readTree(response.getBody());

	    // map to a Collection of Film objects
	    List<MusicFestival> musicFests = mapper.readValue(response.getBody(),  mapper.getTypeFactory().constructCollectionType(List.class, MusicFestival.class));

	    assertThat( responseJson.isMissingNode(), is(false));
	    assertThat( musicFests.get(0).getName(), is("Sunset Music Festival"));
	  }
	}