import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircleTest {

    @Test
    public void testIsPointInside_definedCircle() {
        Circle circle = new Circle(new Point2DDouble(20, 50), 10);
        
        assertTrue(circle.isPointInside(new Point2DDouble(20, 50)));
        assertTrue(circle.isPointInside(new Point2DDouble(11.1, 50)));
        assertTrue(circle.isPointInside(new Point2DDouble(29.9, 50)));
        assertTrue(circle.isPointInside(new Point2DDouble(20, 59.9)));
        assertTrue(circle.isPointInside(new Point2DDouble(20, 41.1)));
        assertTrue(circle.isPointInside(new Point2DDouble(25, 55)));
        
        assertFalse(circle.isPointInside(new Point2DDouble(10, 50)));
        assertFalse(circle.isPointInside(new Point2DDouble(30, 50)));
        assertFalse(circle.isPointInside(new Point2DDouble(20, 60)));
        assertFalse(circle.isPointInside(new Point2DDouble(20, 40)));
        assertFalse(circle.isPointInside(new Point2DDouble(29, 59)));
    }
    
    @Test 
    public void testIsPointInside_defaultCircle() {
        Circle circle = new Circle();
        
        assertTrue(circle.isPointInside(new Point2DDouble(0, 0)));
        assertTrue(circle.isPointInside(new Point2DDouble(-0.9, 0)));
        assertTrue(circle.isPointInside(new Point2DDouble(0.9, 0)));
        assertTrue(circle.isPointInside(new Point2DDouble(0, 0.9)));
        assertTrue(circle.isPointInside(new Point2DDouble(0, -0.9)));
        assertTrue(circle.isPointInside(new Point2DDouble(-0.5, 0.5)));
        
        assertFalse(circle.isPointInside(new Point2DDouble(1, 0)));
        assertFalse(circle.isPointInside(new Point2DDouble(-1, 0)));
        assertFalse(circle.isPointInside(new Point2DDouble(0, 1)));
        assertFalse(circle.isPointInside(new Point2DDouble(0, -1)));
        assertFalse(circle.isPointInside(new Point2DDouble(-0.9, 0.9)));
    }

}