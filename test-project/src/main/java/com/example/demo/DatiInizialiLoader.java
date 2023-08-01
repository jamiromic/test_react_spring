package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatiInizialiLoader {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void autogenerazioneDatiAutomobili() {
		
		int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM automobili", Integer.class);
        
		if (rowCount == 0) {
			String insertData1SQL = "INSERT INTO automobili VALUES (1, 'Diesel', '2018', 'Grigio', 'Audi' ) ";
			jdbcTemplate.execute(insertData1SQL);
			
			String insertData2SQL = "INSERT INTO automobili VALUES (2, 'Benzina', '2016', 'Bianca', 'Fiat' ) ";
			jdbcTemplate.execute(insertData2SQL);
			
			String insertData3SQL = "INSERT INTO automobili VALUES (3, 'Elettrica', '2023', 'Blu', 'Mercedes' ) ";
			jdbcTemplate.execute(insertData3SQL);
	
			String updateSequenceSQL = "UPDATE automobili_seq SET next_val = 4";
			jdbcTemplate.execute(updateSequenceSQL);
		}
	}



    
}

