package homework2;
import java.util.Scanner;
/** This is HW2. 5/04/2022
 * This program is to act as the main chunk of the compiling program.
 * Music collection is supposed to offer the user a variety of options.
 * Such as displaying album titles, being able to change genre, and getting favorite track.
 * This class will call back to album as well as son
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class MusicCollection {
	/* Seperate constructor for the inside while loop
	 * @param albumName
	 * This albumOptions is supposed to present the user with three options
	 * get favorite track is supposed to call the favorite track of the previously selected album.
	 * change genre should allow the user to change the genre of the album as well as the favorite track
	 * Return should exit the while loop and return to the main class
	 * @return
	 */
	public static void albumOptions(Album albumName) {
		/*
		 * Variables needed for use.
		 * input for user use as command
		 * genre for later use to change genre
		 */
		int input = 0;
		String genre = "";
		Scanner scanner = new Scanner(System.in);
		/*
		 * While loop to present the user with the three options
		 */
		while (input != 3) {
			/*
			 * Prints out the options for the user
			 */
			System.out.println(albumName.toString());
			System.out.println("Album options:");
			System.out.println("[1]: Get Favorite Track.");
			System.out.println("[2]: Change Genre");
			System.out.println("[3]: Return");
			input = scanner.nextInt();
			scanner.nextLine();
			/*
			 * if they choose one if operates the getfavoriteTrack constructor from album
			 * if they choose two they should be able to input a genre and it changes for
			 * the album as well as the favorite track
			 * if they choose 3 it will exit the while loop
			 */
			if (input == 1) {
				System.out.println(albumName.getfavoriteTrack());
			}
			if(input == 2) {
				System.out.println("Please enter Genre :");
				genre = scanner.nextLine();
				albumName.setGenre(genre);
			}
		}
		return;
	}
	/*
	 * This is the main method to start the process of giving the user options to
	 * pick an album then call albumOptions
	 * @param
	 * @return
	 */

	public static void main(String[] args) {
		/*
		 * Declaration for the songs and albums per homework
		 * Attempt to use all constructors
		 * Input variable for the user input to select options by number
		 */
		Song song1 = new Song("Hey Ya", "Outkast", "Funk");
		Song song2 = new Song("Lean on Me", "Bill Withers");
		song2.setGenre("Soul Music");
		Song song3 = new Song("","","");
		song3.setArtist("Metallica");
		song3.setGenre("Heavy Metal");
		song3.setTitle("Enter Sandman");
		Album album1 = new Album("Hey Ya!",song1,1);
		Album album2 = new Album("Still Bill",song2);
		Album album3 = new Album("Metallica",song3,1);
		Scanner scanner = new Scanner(System.in);
		int input = 2;
		/*
		 * First while loop to give the user the choice between 3 albums
		 */
		while (input!=0) {
			System.out.println("My music collection: ");
			System.out.println("[1]: "+ album1.getTitle());
			System.out.println("[2]: "+ album2.getTitle());
			System.out.println("[3]: "+ album3.getTitle());
			System.out.println("Please select an album or enter 0 to quit: ");
			input = scanner.nextInt();
			scanner.nextLine();
			/*
			 * if loop that calls to the albumOptions constructor based on input
			 * based on input will provide the constructor with different album
			 */
			if (input == 1) {
				albumOptions(album1);
			}
			else if (input == 2) {
				albumOptions(album2);
			}
			else if (input == 3) {
				albumOptions(album3);
			}
		}
		/*
		 * Cordial thank you as well as closing scanner
		 */
		System.out.println("Thanks for using my program.");
		scanner.close();
	}

}
