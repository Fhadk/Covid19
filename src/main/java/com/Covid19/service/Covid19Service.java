package com.Covid19.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Covid19.model.ActiveUserData;
import com.google.gson.Gson;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author Fhadk
 *
 */

@Service
public class Covid19Service {
	private Logger logger = Logger.getLogger(Covid19Service.class);

	private Map<String, Integer> newCasesCountry = new HashMap<String, Integer>();
	private Map<String, Integer> newCasesCountrySort = new HashMap<String, Integer>();
	private Map<String, Integer> newCases = new HashMap<String, Integer>();
	private CSVReader csvReader;
	private List<String[]> allRows = null;

	@Value("${urlCSV}")
	private String url;
	
	 @Autowired
	 ActiveUserData activeUserData;

	public void csvParser() throws IOException {
		try {
			URL stockURL = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
			csvReader = new CSVReader(in);
			allRows = csvReader.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			csvReader.close();
		}
	}

	/**
	 * @return List<String>
	 */
	public List<String> getActiveUser() {
		return activeUserData.getUsers();
	}

	/**
	 * @return JSON Object
	 */
	public String getNewCasesCountrySort() {
		try {
			if(newCasesCountry.isEmpty())
				getNewCasesCountry();

			newCasesCountrySort = newCasesCountry.entrySet().stream()
					.sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).collect(Collectors
							.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return returnJson(newCasesCountrySort);
	}

	/**
	 * @return JSON Object
	 */
	public String getNewCases() {
		try {
			int value = 0;
			String[] row;

			for (int i = 1; i < allRows.size(); i++) {
				row = allRows.get(i);
					value += Integer.valueOf(row[(row.length) - 1]) - Integer.valueOf(row[(row.length) - 2]);
					newCases.put("Total Cases", value);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return returnJson(newCases);
	}

	/**
	 * @return JSON Object
	 */
	public String getNewCasesCountry(int count) {
		try {

			if(newCasesCountry.isEmpty())
				getNewCasesCountry();

			newCasesCountrySort = newCasesCountry.entrySet().stream()
					.sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
					.limit(count)
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return returnJson(newCasesCountrySort);
	}

	
	/**
	 * @return JSON Object
	 */
	public String getNewCasesCountryDate(String date) {
		try {
			int value = 0, index = 0;
			String[] row;
			
			date = date.replaceAll("-", "\\/");
			
			index = Arrays.asList(allRows.get(0)).indexOf(date);
			
			for (int i = 1; i < allRows.size(); i++) {
				row = allRows.get(i);
					value = Integer.valueOf(row[(row.length) - 1]) - Integer.valueOf(row[index]);
					newCasesCountry.put(row[1], value);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return returnJson(newCasesCountry);
	}
	
	/**
	 * @return JSON Object
	 */
	public String getNewCasesCountry() {
		try {
			int value = 0;
			String[] row;

			for (int i = 1; i < allRows.size(); i++) {
				row = allRows.get(i);
					value = Integer.valueOf(row[(row.length) - 1]) - Integer.valueOf(row[(row.length) - 2]);
					newCasesCountry.put(row[1], value);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return returnJson(newCasesCountry);
	}

	private String returnJson(Map<String, Integer> data) {
		return new Gson().toJson(data);
	}

}
