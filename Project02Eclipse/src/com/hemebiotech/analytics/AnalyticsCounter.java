package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	
	// Initialization of variables to count symptoms
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) {
		
		// Using try-with-resources to ensure the file is closed
		try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
		String line;

		// Reading the file and counting symptoms
		while ((line = reader.readLine()) != null) {
			System.out.println("Symptom from file : " + line);
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;	
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
		}
		
	} catch (IOException e) {
		// Displaying an error if the file is not found 
		System.err.println("Error reading file : " + e.getMessage());
		}
		
		// Generating the output file with the results
		try (FileWriter writer = new FileWriter ("result.out")) {
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
		} catch (IOException e) {
			// Displaying an error if writing to the file fails
			System.err.println("Error writing to file : " + e.getMessage());
		}
	}
}
