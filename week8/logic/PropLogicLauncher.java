package logic;

public class PropLogicLauncher {

    public static void main(String[] args) {

        // Make some new constants
        PropVar p = new PropVar("P");
        PropVar q = new PropVar("Q");
        PropVar r = new PropVar("R");

        // Build some Wffs
        Wff e0 = new NotWff(p);
        Wff e1 = new AndWff(q, e0);
        Wff e2 = new OrWff(e1, p);
        Wff e3 = new NotWff(e2);

        // What does their toString() method produce?
        System.out.println("Display form of Wff e0 is: " + e0);
        System.out.println("Display form of Wff e1 is: " + e1);
        System.out.println("Display form of Wff e2 is: " + e2);
        System.out.println("Display form of Wff e3 is: " + e3);
        System.out.println();

        // Create a Valuation and set some truth values
        Valuation val = new Valuation();
        val.put(p, true);
        val.put(q, false);
        val.put(r, true);

        // Compute the truth values and display the results
        System.out.println("The value of Wff e0 is: " + e0.eval(val));
        System.out.println("The value of Wff e1 is: " + e1.eval(val));
        System.out.println("The value of Wff e2 is: " + e2.eval(val));
        System.out.println("The value of Wff e3 is: " + e3.eval(val));
    }
}