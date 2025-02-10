package Assignment1;

/**
 * Class for WeakPasswordException to be thrown if password length is between 6 and 9 characters.
 * @author El Hadji Sy 
 */

public class WeakPasswordException extends Exception {
	public WeakPasswordException(String message) {
		super(message);
	}
}
