package com.Covid19.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Covid19.service.Covid19Service;


@RestController
@RequestMapping("/COVID-19")
public class RequestController {

	@Autowired
	Covid19Service covid19Service;

	private Logger logger = Logger.getLogger(RequestController.class);
	
//	@ApiOperation(value="Get Latest Records", response=List.class)
//	@ApiOperation(value="getLiveRecord", response=userDefined.class)
//	@RequestMapping(value = "/authenticate")
//	public ResponseEntity<Object> authenticate() throws IOException {
//		logger.info("Function: " + "authenticate");
//		covid19Service.csvParser();
//		return new ResponseEntity<Object>(covid19Service.authenticate(), HttpStatus.OK);
//	}

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
