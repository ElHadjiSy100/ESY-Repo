package Assignment1;

/**
 * Class for NoDigitException to be thrown if password doesn't contain any digits.
 * @author El Hadji Sy 
 */

public class NoDigitException extends Exception {
	public NoDigitException(String message) {
		super(message);
	}
}
