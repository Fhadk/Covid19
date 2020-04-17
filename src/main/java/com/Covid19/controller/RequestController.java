package com.Covid19.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Covid19.model.AuthenticationRequest;
import com.Covid19.model.AuthenticationResponse;
import com.Covid19.service.Covid19Service;
import com.Covid19.service.MyUserDetailsService;
import com.Covid19.util.JwtUtil;


@RestController
public class RequestController {

	@Autowired
	Covid19Service covid19Service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	private Logger logger = Logger.getLogger(RequestController.class);

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			covid19Service.csvParser();
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@RequestMapping(value = "/getActiveUser")
	public ResponseEntity<Object> getActiveUser() throws IOException {
		logger.info("Function: " + "getActiveUser");
		return new ResponseEntity<Object>(covid19Service.getActiveUser(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNewCasesCountry")
	public ResponseEntity<Object> getNewCasesCountry() {
		logger.info("Function: " + "getNewCasesCountry");
		return new ResponseEntity<Object>(covid19Service.getNewCasesCountry(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNewCasesCountrySort")
	public ResponseEntity<Object> getNewCasesCountrySort() {
		logger.info("Function: " + "getNewCasesCountrySort");
		return new ResponseEntity<Object>(covid19Service.getNewCasesCountrySort(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNewCasesCountry/{count}")
	public ResponseEntity<Object> getNewCasesCountry(@PathVariable(value = "count", required = true) int count) {
		logger.info("Function: " + "getNewCasesCountryCount");
		return new ResponseEntity<Object>(covid19Service.getNewCasesCountry(count), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNewCasesCountryDate/{date}")
	public ResponseEntity<Object> getNewCasesCountryDate(@PathVariable(value = "date", required = true) String date) {
		logger.info("Function: " + "getNewCasesCountryDate");
		return new ResponseEntity<Object>(covid19Service.getNewCasesCountryDate(date), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNewCases")
	public ResponseEntity<Object> getNewCases() {
		logger.info("Function: " + "getNewCases");
		return new ResponseEntity<Object>(covid19Service.getNewCases(), HttpStatus.OK);
	}
}
