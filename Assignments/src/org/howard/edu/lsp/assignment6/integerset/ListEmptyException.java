package org.howard.edu.lsp.assignment6.integerset;

/**
 * Class to handle Exceptions potentially caused by smallestelement() and largestelement() methods
 * ListEmptyException is a subclass to Exception as it extends the Exception class already included in Java
 * @author Esau
 * @version 1.0 February 28, 2022
 *
 */
public class ListEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
/**
 * @param sentence is a String value that will be used in a try catch block in the Driver class
 * 
 */
	public ListEmptyException(String sentence) {
		super(sentence);
	}
}
