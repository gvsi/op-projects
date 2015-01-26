import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.awt.Color;

import org.junit.Test;

public class ImageEditor1Test {
    
    private static final double LUMINANCE_CYAN = 178.755;
    private static final double LUMINANCE_MAGENTA = 105.315;
    private static final int GREYVALUE_CYAN = 179;
    private static final int GREYVALUE_MAGENTA = 105;
    
    private static Picture createPicture(Color colour, int width, int height) {
        Picture picture = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                picture.set(i, j, colour);
            }
        }
        return picture;
    }

    @Test
    public void testLuminance() {
        assertEquals(LUMINANCE_CYAN, ImageEditor1.luminance(Color.CYAN), 0.001);
        assertEquals(LUMINANCE_MAGENTA, ImageEditor1.luminance(Color.MAGENTA), 0.001);
    }

    @Test
    public void testToGrey() {
        assertEquals(GREYVALUE_CYAN, ImageEditor1.toGrey(Color.CYAN).getRed());
        assertEquals(GREYVALUE_CYAN, ImageEditor1.toGrey(Color.CYAN).getGreen());
        assertEquals(GREYVALUE_CYAN, ImageEditor1.toGrey(Color.CYAN).getBlue());

        assertEquals(GREYVALUE_MAGENTA, ImageEditor1.toGrey(Color.MAGENTA).getRed());
        assertEquals(GREYVALUE_MAGENTA, ImageEditor1.toGrey(Color.MAGENTA).getGreen());
        assertEquals(GREYVALUE_MAGENTA, ImageEditor1.toGrey(Color.MAGENTA).getBlue());
    }

    @Test
    public void testMakeGreyscale() {
        int width = 20, height = 30;
        Picture original = createPicture(new Color(20, 60, 70), width, height);

        Picture greyscale = ImageEditor1.makeGreyscale(original);
        assertNotSame(original, greyscale);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                assertEquals(49, greyscale.get(i, j).getRed());
                assertEquals(49, greyscale.get(i, j).getGreen());
                assertEquals(49, greyscale.get(i, j).getBlue());
            }
        }
    }

}
