package com.lulu.Lulu02_MS1_Login;
 
import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test; // You should use org.junit.jupiter.api.Test for JUnit 5
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lulu.Lulu02_MS1_Login.entity.Admin;
import com.lulu.Lulu02_MS1_Login.entity.Login;
import com.lulu.Lulu02_MS1_Login.entity.SignUp;
 
@SpringBootTest
class Lulu02Ms1LoginApplicationTests {
 
    @Test
    void contextLoads() {
    }
 
    @Test
    void testcase() {
        System.out.println("Everything is running fine");
    }
    @Test
	public void testAdminReturnEntity() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="";
	    System.out.println("TestCase is Going ON");
	    final String baseUrl = "http://localhost:9111"+ "/api1/admin/getAdmin";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
    @Test
   	public void testLoginReturnEntity() throws URISyntaxException
   	{
   	    RestTemplate restTemplate = new RestTemplate();
   	    //String randomServerPort="";
   	    System.out.println("TestCase is Going ON");
   	    final String baseUrl = "http://localhost:9111"+ "/api1/login/getLogin";
   	    URI uri = new URI(baseUrl);
   	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
   	    //Verify request succeed
   	    assertEquals(200, result.getStatusCodeValue());
   	}
    @Test
   	public void testSignupReturnEntity() throws URISyntaxException
   	{
   	    RestTemplate restTemplate = new RestTemplate();
   	    //String randomServerPort="";
   	    System.out.println("TestCase is Going ON");
   	    final String baseUrl = "http://localhost:9111"+ "/api1/signup/getUser";
   	    URI uri = new URI(baseUrl);
   	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
   	    //Verify request succeed
   	    assertEquals(200, result.getStatusCodeValue());
   	}
    
    @Test
    public void testAddAdmin() throws URISyntaxException
 
    {
    	RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9111"+"/api1/admin/addAdmin";
        URI uri = new URI(baseUrl);
        Admin admin = new Admin(267,"Harini Saravanan");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<Admin> request = new HttpEntity<>(admin, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
    
    @Test
    public void testAddLogin() throws URISyntaxException
 
    {
    	RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9111"+"/api1/login/addLogin";
        URI uri = new URI(baseUrl);
        Login login = new Login(6785,"abhj@gmail.com","abj@j7hb");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<Login> request = new HttpEntity<>(login, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
    
    @Test
    public void testAddSignUp() throws URISyntaxException
 
    {
    	RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9111"+"/api1/signup/addUser";
        URI uri = new URI(baseUrl);
        SignUp signup = new SignUp(4528,"ee57#hn3er34",98253672,"Aisha","aish123@gmail.com","India","Ejipura",5637);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<SignUp> request = new HttpEntity<>(signup, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
    @Test
	public void testDeleteAdmin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing admin deletion");
		final String baseUrl = "http://localhost:9111/api1/signup/deleteUser/267"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
    @Test
	public void testDeleteLogin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing login deletion");
		final String baseUrl = "http://localhost:9111/api1/login/deleteLogin/7384"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
    @Test
	public void testUpdateAdmin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing admin update");
		final String baseUrl = "http://localhost:9111/api1/admin/emp/5678"; // Replace with your actual update endpoint
		URI uri = new URI(baseUrl);
		Admin adminToUpdate = new Admin(5678,"Nishitha");
		restTemplate.put(uri, adminToUpdate);
		// Optionally, verify that the update was successful.
	}
    @Test
	public void testUpdateSignup() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing signup update");
		final String baseUrl = "http://localhost:9111/api1/signup/updateUser/4528"; // Replace with your actual update endpoint
		URI uri = new URI(baseUrl);
		SignUp signupToUpdate = new SignUp(4528,"hujg&bhjvtn990",98764578,"Rose","rose123@gmail.com","India","Vijayanagar",3823);
		restTemplate.put(uri, signupToUpdate);
		// Optionally, verify that the update was successful.
	}
    @Test
	public void testUpdateLogin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing login update");
		final String baseUrl = "http://localhost:9111/api1/login/updateUser/6785"; // Replace with your actual update endpoint
		URI uri = new URI(baseUrl);
		Login loginToUpdate = new Login(6785,"aisha@gmail.com","Ayesha@rdf");
		restTemplate.put(uri, loginToUpdate);
		// Optionally, verify that the update was successful.
	}
}