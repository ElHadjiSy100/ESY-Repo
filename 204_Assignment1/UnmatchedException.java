package Assignment1;

/**
 * Class for UnmatchedException to be thrown if passwords don't match.
 * @author El Hadji Sy 
 */

public class UnmatchedException extends Exception {
	public UnmatchedException(String message) {
		super(message);
	}
}
