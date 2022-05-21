package homework2;
/** This is HW2. 5/04/2022
 * This program is to act as a album declaration for Music Collection.
 * This class will interact with the Song class to store different variables.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class Album {
	/*Privately declared variables needed for each constructor
	 * one static int to keep track of albums
	 * one song favoriteTrack to create a song in the album
	 */
	private String title;
	private String artist;
	private String genre;
	private Song favoriteTrack;
	private int trackNumber;
	static int numAlbums;
	/*
	 * @param title
	 * @param favoriteTrack
	 * @param trackNumber
	 * sets all value for the album class
	 * adds one to the numAlbums counter
	 * @return
	 */
	public Album(String title, Song favoriteTrack, int trackNumber) {
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.trackNumber = trackNumber;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		Album.numAlbums++;
		return;
	}
	/*
	 * @param title
	 * @param favoriteTrack
	 * constructor chains back to Album(String,Song,int)
	 * Sets default trackNumer to 1
	 * @return
	 */
	public Album(String title, Song favoriteTrack) {
		this(title,favoriteTrack,1);
		return;
	}
	public String getTitle() {
		return title;
	}
	public Song getfavoriteTrack() {
		return favoriteTrack;
	}
	public int gettrackNumber() {
		return trackNumber;
	}
	public void setGenre(String genre) {
		this.genre = genre;
		favoriteTrack.setGenre(genre);
	}
	public String toString() {
		return "Title : "+this.title +"\nArtist : " + this.artist  +"\nGenre : " + this.genre; 
	}
}
