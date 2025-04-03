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
	 * @param filepath a full or partial path to a file containing symptoms
	 */
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();
		
				try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					result.add(line);
				}
			} catch (IOException e) {
				System.err.println("Error reading file : " + e.getMessage());
			}		
		return result;
	}
}
