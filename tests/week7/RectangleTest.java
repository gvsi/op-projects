import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RectangleTest {

    @Test
    public void testIsPointInside_definedRectangle() {
        Rectangle rectangle = new Rectangle(new Point2DDouble(20, 200), new Point2DDouble(40, 220));

        assertTrue(rectangle.isPointInside(new Point2DDouble(21, 201)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(21, 219)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(39, 201)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(39, 219)));

        assertFalse(rectangle.isPointInside(new Point2DDouble(30, 199.9)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(30, 220.1)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(19.9, 210)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(40.1, 210)));
    }

    @Test
    public void testIsPointInside_defaultRectangle() {
        Rectangle rectangle = new Rectangle();

        assertTrue(rectangle.isPointInside(new Point2DDouble(0.1, 0.1)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(0.1, 0.9)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(0.9, 0.1)));
        assertTrue(rectangle.isPointInside(new Point2DDouble(0.9, 0.9)));

        assertFalse(rectangle.isPointInside(new Point2DDouble(0.5, -0.1)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(0.5, 1.1)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(-0.1, 0.5)));
        assertFalse(rectangle.isPointInside(new Point2DDouble(1.1, 0.5)));
    }
}
