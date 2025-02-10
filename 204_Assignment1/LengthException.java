package Assignment1;

/**
 * Class for LengthException to be thrown if password length is less than six characters.
 * @author El Hadji Sy 
 */

public class LengthException extends Exception{
	public LengthException(String message) {
		super(message);
	}
}
