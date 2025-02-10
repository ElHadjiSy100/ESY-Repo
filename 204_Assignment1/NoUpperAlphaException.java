package Assignment1;

/**
 * Class for NoUpperAlphaException to be thrown if password doesn't contain any uppercase alphabetic characters.
 * @author El Hadji Sy 
 */

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
