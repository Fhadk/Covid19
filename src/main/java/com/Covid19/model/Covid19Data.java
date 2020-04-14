package com.Covid19.model;

import java.util.List;

import lombok.Data;

@Data
public class Covid19Data {
//	@CsvBindByName(column = "id")
	String ProvinceState;
	String Lat;
	String Long;
	List<String> date;
}
