package Assignment1;

/**
 * Class for NoSpecialCharacterException to be thrown if password doesn't contain any special characters.
 * @author El Hadji Sy 
 */
public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
