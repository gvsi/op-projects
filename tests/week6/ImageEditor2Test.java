import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class ImageEditor2Test {
    
    private static final int HEIGHT = 20;
    private static final int WIDTH = 30;

    private Picture original;

    private static Picture createPicture(Color colour, int width, int height) {
        Picture picture = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                picture.set(i, j, colour);
            }
        }
        return picture;
    }

    @Before
    public void setUp() throws Exception {
        original = createPicture(new Color(20, 60, 70), HEIGHT, WIDTH);
    }

    @Test
    public void testThreshold1() {
        
        Picture g = ImageEditor2.threshold(original, 40);
        assertNotSame(original, g);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                assertEquals(49, g.get(i, j).getRed());
                assertEquals(49, g.get(i, j).getGreen());
                assertEquals(49, g.get(i, j).getBlue());
            }
        }

    }

    @Test
    public void testThreshold2() {

        Picture g = ImageEditor2.threshold(original, 60);
        assertNotSame(original, g);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                assertEquals(0, g.get(i, j).getRed());
                assertEquals(0, g.get(i, j).getGreen());
                assertEquals(0, g.get(i, j).getBlue());
            }
        }

    }

}
