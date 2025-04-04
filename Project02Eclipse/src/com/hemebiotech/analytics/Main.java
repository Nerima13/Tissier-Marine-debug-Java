package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	
	// Main method for the execution
		public static void main(String[] args) {
			
			// Create instances of ISymptomReader, ISymptomWriter and AnalyticsCounter
			ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
			ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
			AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

			// Step 1 : Get symptoms
			List<String> symptoms = counter.getSymptoms();
			
			// Step 2 : Count symptoms
			Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);
			
			// Step 3 : Sort symptoms
			Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);
			
			// Step 4 : Write the result to file
			counter.writeSymptoms(sortedSymptoms);
			
			System.out.println("The processing has been successfully completed.");
		}
}
