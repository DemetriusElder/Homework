package homework2;
/** This is HW2. 5/04/2022
 * This program is to act as a song declaration for album.
 * As well as for Music Collection
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class Song {
	//Privately declared variables needed for each constructor
	private String title;
	private String artist;
	private String genre;
	/*
	 * @param title
	 * @param artist
	 * @param genre
	 * sets all value for the song class
	 * @return
	 */
	public Song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		return;
	}
	/*
	 * @param title
	 * @param artist
	 * constructor chains to Song(String,String,String) and sets genre as Unknown
	 * @return
	 */
	public Song(String title, String artist) {
		this(title,artist,"Unknown");
		return;
	}
	/*Getter for title
	 * @returns title 
	 */
	public String getTitle() {
		return title;
	}
	/*Setter for title
	 * no return
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/*Getter for artist
	 * @returns artist
	 */
	public String getArtist() {
		return artist;
	}
	/*Setter for artist
	*no return
	*/
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/*Getter for genre
	 * returns genre
	 */
	public String getGenre() {
		return genre;
	}
	/*Setter for genre
	 * no return
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/*
	 *overrides java.lang.Object.toString();
	 *@returns a string of artist title genre.
	 */
	public String toString() {
		return artist +" " + title  +" " + genre; 
	}
}
