package com.hemebiotech.analytics;

import java.util.Map;

/** 
 * Interface for writing symptom data to a destination.
 */

public interface ISymptomWriter {
	
	/**
	 * Writes symptoms and their occurrences to a data destination.
	 * If no data is available, an empty list is returned.
	 *  
	 * @return a map containing symptoms as keys and their occurrences as values
	 */
	
	public void writeSymptoms(Map<String, Integer> symptoms);
}
