import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IntervalTest {

    private Interval interval0, interval1, interval2;

    @Before
    public void setUp() {
        interval0 = new Interval(2.0, 1.0); // Empty interval
        interval1 = new Interval(1.0, 2.0);
        interval2 = new Interval(5.0, 10.0);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(interval0.isEmpty());
        assertFalse(interval1.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("Interval: (EMPTY)", interval0.toString());
        assertEquals("Interval: [1.0, 2.0]", interval1.toString());
        assertEquals("Interval: [5.0, 10.0]", interval2.toString());
    }

    @Test
    public void testContains() {
        assertFalse(interval0.doesContain(1.5));
        
        assertTrue(interval1.doesContain(1.3));
        assertFalse(interval1.doesContain(0.9));
        assertFalse(interval1.doesContain(2.1));
    }

    @Test
    public void testIntersects() {
        assertTrue(interval2.intersects(new Interval(7.0, 12.0)));
        assertTrue(interval2.intersects(new Interval(9.0, 14.0)));
        assertTrue(interval2.intersects(new Interval(1.0, 5.0)));
        assertFalse(interval2.intersects(new Interval(1.0, 4.0)));
        assertFalse(interval2.intersects(new Interval(10.1, 14.0)));
        
        assertFalse(interval0.intersects(new Interval(1.5, 2.5)));
    }

}
