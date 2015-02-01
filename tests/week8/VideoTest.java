import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VideoTest {

    // Error tolerance when checking doubles for equality
    private static final double TOLERANCE = 0.001;
    
    private static final String TITLE = "Herbie";

    private PrintStream originalOut;
    private ByteArrayOutputStream capturedOut;

    /**
     * Temporarily captures the output to the standard output stream. 
     * This method is run before every testcase.
     */
    @Before
    public void captureOutput() {
        capturedOut = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(capturedOut));
    }

    /**
     * Restores the standard output stream.
     * This method is run after every testcase.
     */
    @After
    public void restoreOutput() {
        System.setOut(originalOut);
    }

    /**
     * Convert Windows format linefeeds to Unix/Linux/OSX format for string comparison
     * @param input input string containing newlines in '\n', '\r', '\r\n' format
     * @return string containing only '\n' newlines
     */
    private String convertToUnix(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
    }

    @Test
    public void testConstructor() {
        Video video = new Video(TITLE);
        assertEquals(TITLE, video.getTitle());
        assertEquals("Video[title=\"Herbie\", checkedOut=false]", video.toString());

        video = new Video("other");
        assertEquals("other", video.getTitle());
        assertEquals("Video[title=\"other\", checkedOut=false]", video.toString());

    }

    @Test
    public void testAddRating() {
        Video video = new Video(TITLE);
        assertTrue(video.addRating(1));
        assertTrue(video.addRating(5));
    }

    @Test
    public void testAddRating_errorInput() {
        Video video = new Video(TITLE);
        assertFalse(video.addRating(0));
        assertFalse(video.addRating(6));
        assertEquals("0 should be between 1 and 5.\n" + 
        		"6 should be between 1 and 5.", convertToUnix(capturedOut.toString().trim()));
    }

    @Test
    public void testGetAverageRating() {
        Video video = new Video(TITLE);
        assertEquals(0, video.getAverageRating(), TOLERANCE);
        video.addRating(3);
        assertEquals(3, video.getAverageRating(), TOLERANCE);
        video.addRating(2);
        assertEquals(2.5, video.getAverageRating(), TOLERANCE);
    }

    @Test
    public void testCheckout() {
        Video video = new Video(TITLE);
        assertFalse(video.isCheckedOut());
        
        assertTrue(video.checkOut());
        assertTrue(video.isCheckedOut());
        assertEquals("", capturedOut.toString().trim());
    }

    @Test
    public void testCheckout_alreadyCheckedOut() {
        Video video = new Video(TITLE);
        assertFalse(video.isCheckedOut());
        
        assertTrue(video.checkOut());
        assertTrue(video.isCheckedOut());
        
        assertFalse(video.checkOut());
        assertTrue(video.isCheckedOut());
        assertEquals("Video[title=\"Herbie\", checkedOut=true] is already checked out.", capturedOut.toString().trim());
    }

    @Test
    public void testReturnToStore() {
        Video video = new Video(TITLE);
        assertTrue(video.checkOut());
        assertTrue(video.isCheckedOut());
        assertTrue(video.returnToStore());
        assertFalse(video.isCheckedOut());
    }
    
    @Test
    public void testReturnToStore_notCheckedOut() {
        Video video = new Video(TITLE);
        assertFalse(video.isCheckedOut());
        assertFalse(video.returnToStore());
        assertEquals("Video[title=\"Herbie\", checkedOut=false] is not checked out.", capturedOut.toString().trim());
    }

}
