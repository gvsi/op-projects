import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test SaferDivider behaves as expected
 * 
 */
public class SaferDividerTest {

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
            SaferDivider.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void test1() {
        // Call SaferDivider.main() and check the output is as expected.

        String[] args = { "1.0", "1.0" };
        // Convert the String result to a double
        double result = Double.parseDouble(captureOutputOfMain(args));
        // Compare the double result with expected value (allowing an error of
        // 0.001 as doubles are not exact)
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void test2() {
        // Call SaferDivider.main() and check the output is as expected.

        String[] args = { "2.0", "0.5" };
        // Convert the String result to a double
        double result = Double.parseDouble(captureOutputOfMain(args));
        // Compare the double result with expected value (allowing an error of
        // 0.001 as doubles are not exact)
        assertEquals(4.0, result, 0.001);
    }

    @Test
    public void test3() {
        // Call SaferDivider.main() and check the output is as expected.

        String[] args = { "2.0", "0.0" };
        assertEquals("I can't divide by zero!", captureOutputOfMain(args));
    }

}
