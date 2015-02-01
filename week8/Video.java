import java.util.ArrayList;

public class Video {
	private String title;
	private boolean checkedOut;
	private ArrayList<Integer> ratings;
	
	public Video(String title) {
		this.title = title;
		checkedOut = false;
		ratings = new ArrayList<Integer>();
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean addRating(int rating) {
		if (rating >= 1 && rating <= 5) {
			ratings.add(rating);
			return true;
		} else {
			System.out.println(rating + " should be between 1 and 5.");
			return false;
		}
	}
	
	public double getAverageRating() {
		int n = ratings.size();
		if (n == 0) return 0;
		
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += ratings.get(i);
		}
		return (double) total / n;
	}
	
	public boolean checkOut() {
		if (!checkedOut) {
			checkedOut = true;
			return true;
		} else {
			System.out.println(this + " is already checked out.");
			return false;
		}
	}
	
	public boolean returnToStore() {
		if (checkedOut) {
			checkedOut = false;
			return true;
		} else {
			System.out.println(this + " is not checked out.");
			return false;
		}
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public String toString() {
		return String.format("Video[title=\"%s\", checkedOut=%s]", title, checkedOut);
	}

}
