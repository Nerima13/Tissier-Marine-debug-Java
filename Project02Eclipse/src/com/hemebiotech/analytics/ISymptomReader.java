package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptom data from a source.
 * The returned list may contain duplicates.
 */

public interface ISymptomReader {
	
	/**
	 * Reads and returns a list of all symptoms obtained from a data source.
	 * If no data is available, an empty list is returned.
	 * 
	 * @return a list of symptoms, which may contains duplicates
	 */
	
	List<String> getSymptoms ();
}
