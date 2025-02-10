package Assignment1;

import java.lang.String; 
import java.util.ArrayList; 
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Checks validity of passwords and throws exceptions accordingly
 * @author El Hadji Sy
 */
public class PasswordCheckerUtility {
	/**
	 * 
	 * @param password  The password to check.
	 * @param passwordConfrim The password to check against.
	 * @throws UnmatchedException thrown if passwords don't match.
	 */
	public static void comparePasswords(String password, String passwordConfrim) throws UnmatchedException {
		if(!(password.equals(passwordConfrim))){
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	/**
	 * 
	 * @param password    - The password to check
	 * @param passwordConfirm - The Password to check against.
	 * @return True if the passwords are the same.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)) {
			return true;
		}
		
		return false; 
	}
	
	/**
	 * 
	 * @param password - password to check for length
	 * @return True if the password length is equal to or exceeds 6 characters.
	 * @throws LengthException thrown if password length is less than 6 characters.
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if(password.length() >= 6) {
			return true;
		} else {
			throw new LengthException("The password must be at least 6 characters long");
		} 
	}
	
	/**
	 * 
	 * @param password - password to check for uppercase alphabetic characters.
	 * @return True if password contains at least one uppercase alphabetic character.
	 * @throws NoUpperAlphaException thrown if password has no uppercase alphabetical characters.
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			} 
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character"); 
	}
	
	/**
	 * 
	 * @param password - password to check for lowercase alphabetic characters.
	 * @return True if password contains at least one lowercase alphabetic character.
	 * @throws NoLowerAlphaException thrown if password has no lowercase alphabetic characters.
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * 
	 * @param password - password to check for digit.
	 * @return True if password contains at least one digit
	 * @throws NoDigitException thrown if password has no digits.
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			} 
		}
		throw new NoDigitException("The password must contain at least one digit");
	}

	/**
	 * 
	 * @param password - password to check for special character.
	 * @return True if password contains at least one special character.
	 * @throws NoSpecialCharacterException thrown if password has no special characters.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()) {
			return true;
		} 
		throw new NoSpecialCharacterException("The password must contain at least one special character");
	}	
	
	/**
	 * 
	 * @param password - password to check for three of the same character in sequence.
	 * @return True if there aren't three of the same character in sequence.
	 * @throws InvalidSequenceException thrown if there are three of the same character in sequence.
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		boolean invSequence = true;
		for(int i = 0; i < password.length(); i++) {
			if(i >= 2 && (password.charAt(i) == password.charAt(i-1) && password.charAt(i) == password.charAt(i-2))) {
				invSequence = false;
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
			
		}
		return invSequence;
	}
	
	/**
	 * 
	 * @param password - password to check validity of.
	 * @return True if password passes all tests.
	 * @throws LengthException  thrown if password length is less than 6 characters.
	 * @throws NoUpperAlphaException thrown if password has no uppercase alphabetical characters.
	 * @throws NoLowerAlphaException thrown if password has no lowercase alphabetic characters.
	 * @throws NoDigitException thrown if password has no digits.
	 * @throws NoSpecialCharacterException thrown if password has no special characters.
	 * @throws InvalidSequenceException thrown if there are three of the same character in sequence.
	 */
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		return(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) 
				&& hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password));
	}
	
	/**
	 * 
	 * @param - password to check length of
	 * @return True if password length is between 6 and 9 characters.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		return((password.length() >= 6 && password.length() <= 9));
	}
	
	/**
	 * 
	 * @param password - password to check strength of.
	 * @return True if password is weak (length is between 6 and 9 characters).
	 * @throws WeakPasswordException thrown if password is weak (length is between 6 and 9 characters).
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try {	
			if(hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException("Password is OK but weak");
			}
		} catch(WeakPasswordException weakPassword) {
			weakPassword.getMessage();
		}
		return false;
	}
	
	/**
	 * 
	 * @param passwords passwords to check validity of.
	 * @return ArrayList of all invalid passwords with the reason for their invalidation.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
			for(int i = 0; i < passwords.size(); i++) {
				try {
					isValidPassword​(passwords.get(i));
				} catch(Exception length){
					invalidPasswords.add(passwords.get(i) + " " + length.getMessage());
				
				}
			} 
			return invalidPasswords;
	}
	

}
