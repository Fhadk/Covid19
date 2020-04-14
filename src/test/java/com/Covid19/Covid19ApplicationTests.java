package com.Covid19;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Covid19ApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void getNewCasesCountry() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/COVID-19/getNewCasesCountry";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("Pakistan"));
	}
	
	@Test
	public void getNewCases() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/COVID-19/getNewCases";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("Total"));
	}
	
	
	@Test
	public void getNewCasesCountrySort() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/COVID-19/getNewCasesCountrySort";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("Turkey"));
	}

	
	@Test
	public void getNewCasesCountryCount() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/COVID-19/getNewCasesCountry/3";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("US"));
	}
	
	@Test
	public void getNewCasesCountryDate() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/COVID-19/getNewCasesCountryDate/4-11-20";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("US"));
	}
}
