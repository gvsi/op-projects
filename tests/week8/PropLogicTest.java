package logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ewan Klein <ewan@inf.ed.ac.uk>
 * 
 */
public class PropLogicTest {

    private PropVar p = new PropVar("P");
    private PropVar q = new PropVar("Q");
    private PropVar r = new PropVar("R");
    private PropVar t = new PropVar("True");
    private PropVar f = new PropVar("False");

    // Negation
    private Wff notP = new NotWff(p); // false
    private Wff notQ = new NotWff(q); // true

    // Conjunction
    private Wff and0 = new AndWff(q, notP);

    private Wff andTT = new AndWff(t, t);
    private Wff andFT = new AndWff(f, t);
    private Wff andTF = new AndWff(t, f);
    private Wff andFF = new AndWff(f, f);

    // Disjunction
    private Wff or0 = new OrWff(and0, p);
    private Wff or1 = new OrWff(and0, or0);

    private Wff orTT = new OrWff(t, t);
    private Wff orFT = new OrWff(f, t);
    private Wff orTF = new OrWff(t, f);
    private Wff orFF = new OrWff(f, f);

    // Implication
    private Wff if0 = new IfWff(and0, p);
    private Wff if1 = new IfWff(and0, if0);

    private Wff ifTT = new IfWff(t, t);
    private Wff ifFT = new IfWff(f, t);
    private Wff ifTF = new IfWff(t, f);
    private Wff ifFF = new IfWff(f, f);

    private Wff notQAndNotPOrR = new NotWff(or0);
    private Valuation valuation = new Valuation();

    @Before
    public void setUp() {
        valuation.put(p, true);
        valuation.put(q, false);
        valuation.put(r, true);
        valuation.put(t, true);
        valuation.put(f, false);
    }

    /**
     * Propositional Constants
     */
    @Test
    public void testToStringPropConstant() {
        assertEquals("P", p.toString());
    }

    @Test
    public void testEvalPropConstant() {
        assertTrue(p.eval(valuation));
        assertFalse(q.eval(valuation));
    }

    /**
     * Negation
     */
    @Test
    public void testToStringNotWff() {
        assertEquals("~P", notP.toString());
        assertEquals("~((Q & ~P) | P)", notQAndNotPOrR.toString());
    }

    @Test
    public void testEvalNotWff() {
        assertFalse(notP.eval(valuation));
        assertTrue(notQ.eval(valuation));
    }

    /**
     * Conjunction
     */
    @Test
    public void testToStringAndWff() {
        assertEquals("(Q & ~P)", and0.toString());
    }

    @Test
    public void testEvalAndWff() {
        assertTrue(andTT.eval(valuation));
        assertFalse(andTF.eval(valuation));
        assertFalse(andFT.eval(valuation));
        assertFalse(andFF.eval(valuation));
    }

    /**
     * Disjunction
     */
    @Test
    public void testToStringOrWff() {
        assertEquals("((Q & ~P) | P)", or0.toString());
        assertEquals("((Q & ~P) | ((Q & ~P) | P))", or1.toString());
    }

    @Test
    public void testEvalOrWff() {
        assertTrue(orTT.eval(valuation));
        assertTrue(orTF.eval(valuation));
        assertTrue(orFT.eval(valuation));
        assertFalse(orFF.eval(valuation));
    }

    /**
     * Implication
     */
    @Test
    public void testToStringIfWff() {
        assertEquals("((Q & ~P) -> P)", if0.toString());
        assertEquals("((Q & ~P) -> ((Q & ~P) -> P))", if1.toString());
    }

    @Test
    public void testEvalIfWff() {
        assertTrue(ifTT.eval(valuation));
        assertFalse(ifTF.eval(valuation));
        assertTrue(ifFT.eval(valuation));
        assertTrue(ifFF.eval(valuation));
    }
}
