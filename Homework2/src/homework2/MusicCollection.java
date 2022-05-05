package homework2;
import java.util.Scanner;
/** This is HW2. 5/04/2022
 * This program is to act as a song declaration for album.
 * As well as for Music Collection
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class MusicCollection {
	public static void albumOptions(Album albumName) {
		int input = 0;
		String genre = "";
		Scanner scanner = new Scanner(System.in);
		while (input != 3) {
			System.out.println(albumName.toString());
			System.out.println("Album options:");
			System.out.println("[1]: Get Favorite Track.");
			System.out.println("[2]: Change Genre");
			System.out.println("[3]: Return");
			input = scanner.nextInt();
			scanner.nextLine();
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

	public static void main(String[] args) {
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
		System.out.println(song1.toString());
		System.out.println(song2.toString());
		System.out.println(song3.toString());
		System.out.println(album1.toString());
		System.out.println(album2.toString());
		System.out.println(album3.toString());
		Scanner scanner = new Scanner(System.in);
		int input = 2;
		while (input!=0) {
			System.out.println("My music collection: ");
			System.out.println("[1]: "+ album1.getTitle());
			System.out.println("[2]: "+ album2.getTitle());
			System.out.println("[3]: "+ album3.getTitle());
			System.out.println("Please select an album or enter 0 to quit: ");
			input = scanner.nextInt();
			scanner.nextLine();
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
		System.out.println("Thanks for using my program.");
		scanner.close();
	}

}
