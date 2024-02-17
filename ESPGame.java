package ESPGame;
import java.util.*;
public class ESPGame {
	/*
	 * Class: CMSC203 31480
	 * Instructor: Professor Ashique Tanveer
	 * Description: Create a game to test your extra sensory perception 
	 * Due: 2/16/2024
	 * Platform/compiler: Eclipse IDE
	 * I pledge that I have completed the programming assignment 
	* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
	 * Print your Name here: El Hadji Sy 
	*/

	public static void main(String[] args){
		//This first branch of code is to receive the name, description, and due date inputs from the user.
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter your name:");
		String studentName = stdin.nextLine();
		System.out.println("Describe yourself: ");
		String studentDescription = stdin.nextLine();
		System.out.println("Due Date: ");
		String dueDate = stdin.nextLine();
		System.out.println("CMSC203 Assignment 1: Test your ESP skills!");
		
		//This second branch of code is creating the actual ESP game, plus the reprint of the user's inputs afterwards.				
		int count = 0;
		for(int i = 1; i <= 11; i++) {
			System.out.println("Round " + i);
			String colors = "Blue"; 
			Random randomNumbers = new Random();
			int number = randomNumbers.nextInt(8);
			switch(number) {
				case 1: colors = "Red";
				break; 
				case 2: colors = "Yellow";
				break;
				case 3: colors = "Orange";
				break;
				case 4: colors = "White";
				break;
				case 5: colors = "Purple";
				break;
				case 6: colors = "Green";
				break;
			}
			System.out.println("\nI am thinking of a color. Is it Blue, Yellow, Red, Green, Purple, Orange, or White?");
			String guess = stdin.nextLine().toLowerCase();
			while(!guess.equals("blue") && !guess.equals("red") && !guess.equals("green") && !guess.equals("yellow") && !guess.equals("white") && !guess.equals("orange") && !guess.equals("purple")) {
				System.out.println("You entered incorrect color. Is it Red, Green, Blue, Orange, or Yellow?");
				guess = stdin.nextLine();
			}
			if(guess.equalsIgnoreCase(colors)) {
				count += 1; 
			}
			System.out.println("\nI was thinking of " + colors);
		}
		System.out.println("\n\nGame Over.\n\n");
		System.out.println("You guessed " + count + " out of 11 colors correctly.");
		System.out.println("Student's name: " + studentName);
		System.out.println("User Description: " + studentDescription);
		System.out.println("Due Date: " + dueDate);
	}
}


