package lab_1;

import java.util.Scanner;

public class MovieDriver_Task1 {
	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		Movie movie = new Movie();
		System.out.println("Enter the title of a movie: ");
		String title = keyboard.nextLine();
		movie.setTitle(title);
		System.out.println("Enter the movie's rating: ");
		String rating = keyboard.nextLine();
		movie.setRating(rating);
		System.out.println("Enter the number of tickets sold for this movie: ");
		int soldTickets = keyboard.nextInt();
		movie.setSoldTickets(soldTickets);
		System.out.println(movie.toString());
		}
	}

