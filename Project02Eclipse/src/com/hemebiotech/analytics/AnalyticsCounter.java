package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	// Constructor with ISymptomReader and ISymptomWriter parameters
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	// Method to get the list of symptoms from the file
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	// Method to count the occurrences of each symptom
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptomCounts, 0) + 1);
		}
		return symptomCounts;
	}
	
	// Method to sort symptoms alphabetically
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);		// Sort by keys (symptom names)
	}
	
	// Method to write the symptoms and their occurrences to the output file
		public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
		}
	
	// Main method that executes
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
	}
}

