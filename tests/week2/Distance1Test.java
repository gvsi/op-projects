import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test Distance1 behaves as expected
 * 
 */
public class Distance1Test {

    /**
     * Temporarily captures the output to the standard output stream, then
     * restores the standard output stream once complete.
     * 
     * Note: the implementation details of this function are advanced. If you
     * don't understand it just now, don't worry.
     * 
     * @param args
     *            arguments to pass to main function of class to be tested
     * @return output result of calling main function of class to be tested
     */
    private String captureOutputOfMain(String args[]) {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            Distance1.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call Distance1.main() and check the output is as expected.
        String[] args1 = { "2", "3" };
        assertEquals("1", captureOutputOfMain(args1));

        String[] args2 = { "4", "2" };
        assertEquals("2", captureOutputOfMain(args2));

        String[] args3 = { "1", "1" };
        assertEquals("0", captureOutputOfMain(args3));
    }
}
