import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class AndWffTest {

    @Test
    public void testAndWff() {
        PropVar p = new PropVar("P");
        PropVar q = new PropVar("Q");
        AndWff andWff = new AndWff(p, q);
        assertSame(p, andWff.getLeft());
        assertSame(q, andWff.getRight());
        assertSame(Operator.AND, andWff.getOp());
        assertEquals("(P & Q)", andWff.toString());
   }

}
