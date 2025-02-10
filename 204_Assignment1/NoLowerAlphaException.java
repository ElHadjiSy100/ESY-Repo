package Assignment1;

/**
 * Class for NoLowerAlphaException to be thrown if password doesn't contain any lowercase alphabetic characters.
 * @author El Hadji Sy 
 */
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException(String message) {
		super(message);
	}
}