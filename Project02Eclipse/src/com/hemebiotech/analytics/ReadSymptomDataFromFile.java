package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation that reads symptom data from a file.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Constructor to initialize the file path.
	 * 
	 * @param filepath a full or partial path to a file containing symptoms strings, one per line
	 */
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
