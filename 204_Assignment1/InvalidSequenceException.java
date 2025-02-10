package Assignment1;
/**
 * Class for InvalidException to be thrown if password contains three or more of the same
 * character in sequence.
 * @author El Hadji Sy 
 */
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException(String message) {
		super(message);
	}
}
