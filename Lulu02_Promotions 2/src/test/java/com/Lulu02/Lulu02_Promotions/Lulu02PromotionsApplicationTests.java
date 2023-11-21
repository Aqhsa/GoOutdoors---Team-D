package com.Lulu02.Lulu02_Promotions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Lulu02.Lulu02_Promotions.entity.Promotion;

@SpringBootTest
class Lulu02PromotionsApplicationTests {

	@Test
	void contextLoads() {
	}
	// Get Operation
			@Test
			public void testgetUser() throws URISyntaxException {
				RestTemplate restTemplate = new RestTemplate();
				// String randomServerPort="8080";
				System.out.println("Testcase is going on");
				final String baseUrl = "http://localhost:9117" + "/promo1/Promotion";
				URI uri = new URI(baseUrl);
				ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
				// Verify request succeed
				assertEquals(200, result.getStatusCodeValue());
			}
		
			// Post Operation
			@Test
			public void testAddEmployeeSuccess() throws URISyntaxException
			{
				RestTemplate restTemplate = new RestTemplate();
				final String baseUrl = "http://localhost:9117" + "/promo1/Promotion";
				URI uri = new URI(baseUrl);
				Promotion user = new Promotion(2, "11-10-2023", "WELCOME5",5);
				HttpHeaders headers = new HttpHeaders();
				headers.set("X-COM-PERSIST", "true");
				HttpEntity<Promotion> request = new HttpEntity<>(user, headers);
				ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
				// Verify request succeed
				assertEquals(200, result.getStatusCodeValue());
			}
			
			//Delete
			@Test
			public void testDeleteEmployee() throws URISyntaxException {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("Testing Promo code deletion");
				final String baseUrl = "http://localhost:9117/promo1/Promotion/1"; // Replace with your actual delete endpoint
				URI uri = new URI(baseUrl);
				restTemplate.delete(uri);
				// Optionally, verify that the delete was successful.
			}
		
			
			//Put Operation
			@Test
			public void testUpdateEmployee() throws URISyntaxException {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("Testing promocode update");
				final String baseUrl = "http://localhost:9117/promo1/Promotion/53752"; // Replace with your actual update endpoint
				URI uri = new URI(baseUrl);
				Promotion employeeToUpdate = new Promotion(53752, "23-11-2023", "HIFIVE20",20);
				restTemplate.put(uri, employeeToUpdate);
				// Optionally, verify that the update was successful.
			}


}
