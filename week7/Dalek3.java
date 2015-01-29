import java.util.ArrayList;

public class Dalek3 {
	
	private ArrayList<String> sayings = new ArrayList<String>();
	
	public void setSayings(String[] phrases) {
		for (String phrase : phrases) {
			sayings.add(phrase);
		}
	}
	
	public void addSaying(String s) {
		sayings.add(s);
	}
	
	public void speak() {
		if (sayings.size() != 0) {
			System.out.println(sayings.get((int)(Math.random() * sayings.size())));
		} else {
			System.out.println("No utterances installed!");
		}
	}
	
	public static void main(String[] args) {

		Dalek3 d1 = new Dalek3();
	    String[] u1 = { "Exterminate, Exterminate!", "I obey!",
	            "Exterminate, annihilate, DESTROY!", "You cannot escape.",
	            "Daleks do not feel fear.", "The Daleks must survive!" };
	    d1.setSayings(u1);

	    System.out.println("\nDalek d1 says: ");
	    for (int i = 0; i < 10; i++) {
	        d1.speak();
	    }

	    System.out.println("\nDalek d2 says: ");
	    Dalek3 d2 = new Dalek3();
	    String[] u2 = { "I obey!" };
	    d2.setSayings(u2);

	    for (int i = 0; i < 10; i++) {
	        d2.speak();
	    }

	}

}
