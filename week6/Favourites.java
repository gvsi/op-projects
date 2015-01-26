public class Favourites {
	MusicTrack[] favourites = new MusicTrack[5];
	
	public void addTrack(String artist, String title) {
		if (this.favourites[4] != null) {
			System.out.println("Sorry, can't add: " + new MusicTrack(artist, title) + "\n");
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (this.favourites[i] == null) {
				this.favourites[i] = new MusicTrack(artist, title);
				break;
			}
		}
	}
	
	public void showFavourites() {
		for (int i = 0; i < 5; i++) {
			if (this.favourites[i] != null) {
				System.out.println(this.favourites[i]);
			} else {
				break;
			}
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
