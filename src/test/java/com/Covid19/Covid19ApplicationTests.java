package com.Covid19;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Covid19ApplicationTests {

	@LocalServerPort
	int randomServerPort;
	
	private HttpHeaders requestHeaders = new HttpHeaders();
	private HttpEntity<String> request;
	private ResponseEntity<String> response;
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getNewCasesCountry() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getNewCasesCountry";
		
		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(true, response.getBody().contains("Pakistan"));
	}
	
	@Test
	public void getNewCases() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getNewCases";
		
		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(true, response.getBody().contains("Total"));
	}
	
	
	@Test
	public void getNewCasesCountrySort() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getNewCasesCountrySort";
		
		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(true, response.getBody().contains("Turkey"));
	}

	
	@Test
	public void getNewCasesCountryCount() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getNewCasesCountry/3";

		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(true, response.getBody().contains("US"));
	}
	
	@Test
	public void getNewCasesCountryDate() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getNewCasesCountryDate/4-11-20";
		
		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(true, response.getBody().contains("US"));
	}
	
	
	@Test
	public void getActiveUser() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/getActiveUser";
		
		requestHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1ODY5MTgwNzcsImlhdCI6MTU4Njg4MjA3N30.xpTnGJ-Inc5YgUcLu6AP98_cUxc9juh4Amzk8tF1zrk");
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		request = new HttpEntity<String>(requestHeaders);
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}
}

