import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VideoStoreTest {

    // Error tolerance when checking doubles for equality
    private static final double TOLERANCE = 0.001;


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

    @Test
    public void testAddAndGetVideo() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        assertEquals("Tron", videoStore.getVideo("Tron").getTitle());
        
        // No error message expected
        assertEquals("", capturedOut.toString().trim());
    }

    @Test
    public void testGetVideo_unknownVideo() {
        VideoStore videoStore = new VideoStore();
        assertNull(videoStore.getVideo("Missing Movie"));
        assertEquals("Sorry, cannot find the requested video in the catalogue", capturedOut.toString().trim());
    }

    @Test
    public void testAddVideo_duplicateVideo() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        assertFalse(videoStore.addVideo("Tron"));
        assertEquals("Tron is already in stock.", capturedOut.toString().trim());
    }

    @Test
    public void testCheckout_unknownVideo() {
        VideoStore videoStore = new VideoStore();
        assertFalse(videoStore.checkOutVideo("Unknown"));
        
        // Expected warning
        assertEquals("Sorry, cannot find the requested video in the catalogue", capturedOut.toString().trim());
    }
    

    @Test
    public void testCheckout_normalCheckout() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        Video video = videoStore.getVideo("Tron");
        assertFalse(video.isCheckedOut());
        
        assertTrue(videoStore.checkOutVideo("Tron"));
        assertTrue(video.isCheckedOut());
        
        // No error message expected
        assertEquals("", capturedOut.toString().trim());
    }

    @Test
    public void testCheckout_alreadyCheckedOut() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        Video video = videoStore.getVideo("Tron");
        assertFalse(video.isCheckedOut());
        
        assertTrue(videoStore.checkOutVideo("Tron"));
        assertTrue(video.isCheckedOut());

        assertFalse(videoStore.checkOutVideo("Tron"));
        assertTrue(video.isCheckedOut());

        // Expected warning
        assertEquals("Video[title=\"Tron\", checkedOut=true] is already checked out.", capturedOut.toString().trim());
    }

    @Test
    public void testReturnVideo_unknownVideo() {
        VideoStore videoStore = new VideoStore();
        Video unknownVideo = new Video("unknown");
        unknownVideo.checkOut();
        assertFalse(videoStore.returnVideo(unknownVideo));
        
        // Expected warning
        assertEquals("Sorry, this video did not come from this store", capturedOut.toString().trim());
    }
    
    @Test
    public void testReturnVideo_unknownVideoWithSameTitle() {
        VideoStore videoStore = new VideoStore();
        
        assertTrue(videoStore.addVideo("Tron"));
        assertTrue(videoStore.checkOutVideo("Tron"));

        // Create another video object with the same title
        Video unknownVideo = new Video("Tron");
        unknownVideo.checkOut();
        // Even if the video has the same name, it was not the same object owned by the video store
        assertFalse(videoStore.returnVideo(unknownVideo));
        
        // Expected warning
        assertEquals("Sorry, this video did not come from this store", capturedOut.toString().trim());
    }
    
    @Test
    public void testReturnVideo_notCheckedOut() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        Video video = videoStore.getVideo("Tron");
        assertFalse(video.isCheckedOut());

        assertFalse(video.returnToStore());
        assertFalse(video.isCheckedOut());
        
        // Expected warning
        assertEquals("Video[title=\"Tron\", checkedOut=false] is not checked out.", capturedOut.toString().trim());
    }
    
    @Test
    public void testReturnVideo_normalReturn() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        assertTrue(videoStore.checkOutVideo("Tron"));
        Video video = videoStore.getVideo("Tron");
        assertTrue(video.isCheckedOut());

        assertTrue(video.returnToStore());
        assertFalse(video.isCheckedOut());
        
        // No error message expected
        assertEquals("", capturedOut.toString().trim());
    }

    @Test
    public void testReturnVideo_doubleReturn() {
        VideoStore videoStore = new VideoStore();
        assertTrue(videoStore.addVideo("Tron"));
        assertTrue(videoStore.checkOutVideo("Tron"));
        Video video = videoStore.getVideo("Tron");
        assertTrue(video.isCheckedOut());

        assertTrue(video.returnToStore());
        assertFalse(video.isCheckedOut());

        assertFalse(video.returnToStore());
        assertFalse(video.isCheckedOut());
        
        // Expected warning
        assertEquals("Video[title=\"Tron\", checkedOut=false] is not checked out.", capturedOut.toString().trim());
    }


	

	@Test
	public void testRateVideo() {
		VideoStore videoStore = new VideoStore();
		assertTrue(videoStore.addVideo("Tron"));
		Video video = videoStore.getVideo("Tron");
		assertEquals(0, videoStore.getAverageRatingForVideo(video), TOLERANCE);
		videoStore.rateVideo(video, 3);
		assertEquals(3, videoStore.getAverageRatingForVideo(video), TOLERANCE);
		videoStore.rateVideo(video, 2);
		assertEquals(2.5, videoStore.getAverageRatingForVideo(video), TOLERANCE);
	}
	
	@Test
	public void testMostPopular(){
		VideoStore videoStore = new VideoStore();
		
		assertTrue(videoStore.addVideo("RED"));
		assertTrue(videoStore.addVideo("Presto"));
		assertTrue(videoStore.addVideo("Kiwi!"));
		
		Video video0 = videoStore.getVideo("RED");
		Video video1 = videoStore.getVideo("Presto");
		Video video2 = videoStore.getVideo("Kiwi!");
		
		videoStore.rateVideo(video0, 3);
		videoStore.rateVideo(video0, 2);
		
		videoStore.rateVideo(video1, 3);
		videoStore.rateVideo(video1, 4);
		
		videoStore.rateVideo(video2, 1);
		videoStore.rateVideo(video2, 2);
		
		assertEquals(video1, videoStore.mostPopular());
	}

	@Test
	public void testGetCheckedOut() {
		VideoStore videoStore = new VideoStore();
		assertArrayEquals(new Video[] {}, videoStore.getCheckedOut());
		
        assertTrue(videoStore.addVideo("RED"));
        assertTrue(videoStore.addVideo("Presto"));
        assertTrue(videoStore.addVideo("Kiwi!"));
        assertTrue(videoStore.addVideo("Skhizein"));
        
        Video video1 = videoStore.getVideo("Presto");
        Video video2 = videoStore.getVideo("Kiwi!");
        
        Video[] expectedCheckedOut = new Video[] {};
        assertArrayEquals(expectedCheckedOut, videoStore.getCheckedOut());
        
        videoStore.checkOutVideo("Presto");
        expectedCheckedOut = new Video[] { video1 };
        assertArrayEquals(expectedCheckedOut, videoStore.getCheckedOut());
        
        videoStore.checkOutVideo("Kiwi!");
        expectedCheckedOut = new Video[] { video1, video2 };
        assertArrayEquals(expectedCheckedOut, videoStore.getCheckedOut());
        
        videoStore.returnVideo(video1);
        expectedCheckedOut = new Video[] { video2 };
        assertArrayEquals(expectedCheckedOut, videoStore.getCheckedOut());
	}
	
}
