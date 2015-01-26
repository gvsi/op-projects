public class MusicTrack {
	private String artist;
	private String title;
	
	public MusicTrack(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		return title + " | " + artist;
	}
}
