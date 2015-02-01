import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class IfWffTest {

    @Test
    public void testIfWff() {
        PropVar p = new PropVar("P");
        PropVar q = new PropVar("Q");
        IfWff ifWff = new IfWff(p, q);
        assertSame(p, ifWff.getLeft());
        assertSame(q, ifWff.getRight());
        assertSame(Operator.IF, ifWff.getOp());
        assertEquals("(P -> Q)", ifWff.toString());
    }

}
