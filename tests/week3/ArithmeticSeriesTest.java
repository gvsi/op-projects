import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test ArithmeticSeries behaves as expected
 * 
 */
public class ArithmeticSeriesTest {

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
            ArithmeticSeries.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call ArithmeticSeries.main() and check the output is as expected.
        String[] args1 = { "5" };
        assertEquals("15", captureOutputOfMain(args1));

        String[] args2 = { "6" };
        assertEquals("21", captureOutputOfMain(args2));

        String[] args3 = { "7" };
        assertEquals("28", captureOutputOfMain(args3));

    }
}
