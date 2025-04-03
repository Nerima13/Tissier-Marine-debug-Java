package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation that writes symptom data to a file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	/**
	 * Constructor to initialize the file path.
	 * 
	 * @param filepath a full or partial path to the output file
	 */

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (filepath != null && symptoms != null) {
			try (FileWriter writer = new FileWriter(filepath)) {
				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			} catch (IOException e) {
				System.err.println("Error writing to file : " + e.getMessage());
			}
		}
	}
}
