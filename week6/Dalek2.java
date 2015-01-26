public class Dalek2 {
	
	private String[] sayings;
	
	public void setSayings(String[] phrases) {
		this.sayings = new String[phrases.length];
		for (int i = 0; i < phrases.length; i++) {
			this.sayings[i] = phrases[i];
		}
	}
	
	public void speak() {
		if (this.sayings != null) {
			System.out.println(this.sayings[(int) (Math.random() * this.sayings.length)]);
		} else {
			System.out.println("No utterances installed!");
		}
	}
	
	public static void main(String[] args) {

	    Dalek2 d1 = new Dalek2();
	    String[] u1 = { "Exterminate, Exterminate!", "I obey!",
	            "Exterminate, annihilate, DESTROY!", "You cannot escape.",
	            "Daleks do not feel fear.", "The Daleks must survive!" };
	    d1.setSayings(u1);

	    System.out.println("\nDalek d1 says: ");
	    for (int i = 0; i < 10; i++) {
	        d1.speak();
	    }

	    System.out.println("\nDalek d2 says: ");
	    Dalek2 d2 = new Dalek2();
	    String[] u2 = { "I obey!" };
	    d2.setSayings(u2);

	    for (int i = 0; i < 10; i++) {
	        d2.speak();
	    }

	}

}
