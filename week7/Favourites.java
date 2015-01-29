import java.util.ArrayList;

import music.MusicTrack;

public class Favourites {
	ArrayList<MusicTrack> favourites = new ArrayList<MusicTrack>();
	
	public void addTrack(String artist, String title) {
		favourites.add(new MusicTrack(artist, title));
	}
	
	public void showFavourites() {
		for (MusicTrack favourite : favourites) {
			System.out.println(favourite);
		}
	}
	
	public static void main (String[] args) {
		Favourites favourites = new Favourites();
		favourites.addTrack("Fun", "Some Nights");
		favourites.addTrack("Oliver Tank", "Help You Breathe");
		favourites.addTrack("Horse Feathers", "Fit Against the Country");
		favourites.addTrack("Emile Sande", "Country House");
		favourites.addTrack("Fun", "Walking the Dog");
		favourites.addTrack("Porcelain Raft", "Put Me To Sleep");
		favourites.showFavourites();
	}
}
