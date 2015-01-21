import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test Multiplier behaves as expected
 * 
 */
public class MultiplierTest {

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
            Multiplier.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call Multiplier.main() and check the output is as expected.
        String[] args1 = { "2", "3", "2" };
        assertEquals("2 * 3 * 2 = 12", captureOutputOfMain(args1));

        String[] args2 = { "4", "2", "3" };
        assertEquals("4 * 2 * 3 = 24", captureOutputOfMain(args2));

        String[] args3 = { "1", "1", "1" };
        assertEquals("1 * 1 * 1 = 1", captureOutputOfMain(args3));
    }

}
