import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class BinaryWffTest {
	
	@Test
	public void testBinaryWff() {
	    PropVar p = new PropVar("P");
	    PropVar q = new PropVar("Q");
	    BinaryWff binaryWff = new BinaryWff(p, q);
		assertSame(p, binaryWff.getLeft());
		assertSame(q, binaryWff.getRight());
		assertNull(binaryWff.getOp());
		assertEquals("(P null Q)", binaryWff.toString());
	}

	@Test
	public void testSetOp() {
        BinaryWff binaryWff = new BinaryWff(new PropVar("P"), new PropVar("Q"));
        assertNull(binaryWff.getOp());
        
        binaryWff.setOp(Operator.AND);
        assertSame(Operator.AND, binaryWff.getOp());
        assertEquals("(P & Q)", binaryWff.toString());
	}

}
