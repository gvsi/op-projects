import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test LargestDouble behaves as expected
 * 
 */
public class LargestDoubleTest {

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
            LargestDouble.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call LargestDouble.main() and check the output is as expected.
        
        String[] args1 = { "2.0", "3.0" };
        // Convert the String result to a double
        double result1 = Double.parseDouble(captureOutputOfMain(args1));
        // Compare the double result with expected value (allowing an error of 0.000001 as doubles are not exact)
        assertEquals(3.0, result1, 0.000001);

        String[] args2 = { "4.0", "2.2" };
        double result2 = Double.parseDouble(captureOutputOfMain(args2));
        assertEquals(4.0, result2, 0.000001);

        String[] args3 = { "4.02", "4.03" };
        double result3 = Double.parseDouble(captureOutputOfMain(args3));
        assertEquals(4.03, result3, 0.000001);
    }
}
