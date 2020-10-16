package br.com.unip.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Data {

	LocalDate data;
	
	public Data(String data) { 
		this.data= LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
		
	}
}
