package com.lulu.Lulu02_MS1_ReturnsManagement;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.lulu.Lulu02_MS1_ReturnsManagement.entity.Returns;

@SpringBootTest
class Lulu02Ms1ReturnsManagementApplicationTests {

	@Test
	void contextLoads() {
	}
	 @Test
	    void testcase() {
	        System.out.println("Everything is running fine");
	    }
	    @Test
		public void testgetReturnEntity() throws URISyntaxException
		{
		    RestTemplate restTemplate = new RestTemplate();
		    //String randomServerPort="";
		    System.out.println("TestCase is Going ON");
		    final String baseUrl = "http://localhost:9114"+ "/return/getReturns";
		    URI uri = new URI(baseUrl);
		    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		    //Verify request succeed
		    assertEquals(200, result.getStatusCodeValue());
		}
	    
	    @Test
	    public void testAddReturn() throws URISyntaxException
	 
	    {
	    	RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:9114"+"/return/addReturns";
	        URI uri = new URI(baseUrl);
	        Returns returns = new Returns(5673,1233,"09-10-2023","Not satisfied","Pending");
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");      
	        HttpEntity<Returns> request = new HttpEntity<>(returns, headers);
	        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	        //Verify request succeed
	        assertEquals(200, result.getStatusCodeValue());
	    }
	    @Test
		public void testDeleteLogin() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("Testing Returns deletion");
			final String baseUrl = "http://localhost:9114"+"/return/deleteReturn/2345"; // Replace with your actual delete endpoint
			URI uri = new URI(baseUrl);
			restTemplate.delete(uri);
			// Optionally, verify that the delete was successful.
		}
	    @Test
		public void testUpdateLogin() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("Testing return update");
			final String baseUrl = "http://localhost:9114"+"/return/updateReturn/5673"; // Replace with your actual update endpoint
			URI uri = new URI(baseUrl);
			Returns returnToUpdate = new Returns(5673,679,"09-10-2023","Color not same","Pending");
			restTemplate.put(uri, returnToUpdate);
			// Optionally, verify that the update was successful.
		}

}
