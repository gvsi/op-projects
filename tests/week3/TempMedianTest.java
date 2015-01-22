import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test TempMedian behaves as expected
 * 
 */
public class TempMedianTest {

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
            TempMedian.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    /**
     * Rather than writing the same code repeatedly, we call a function to run
     * the same code each time. The function parameters change with each test
     * case.
     */
    @Test
    public void testCallingMainGeneralCase() {
        String[] args1 = { "34", ".", ".", ".", "+", ".", "-", "-", "-", ".", "+" };
        checkCallingMain(args1, "34 34 34 34 35 35 34 33 32 32 33", "32 32 33 33 34 34 34 34 34 35 35", 34);

        String[] args2 = { "7", "-", "-", "-", ".", "." };
        checkCallingMain(args2, "7 6 5 4 4 4", "4 4 4 5 6 7", 4.5);

        String[] args3 = { "10", "-", "+", ".", "-", ".", "-", ".", "+" };
        checkCallingMain(args3, "10 9 10 10 9 9 8 8 9", "8 8 9 9 9 9 10 10 10", 9.0);

        String[] args4 = { "3", "-", "-", "-", "-" };
        checkCallingMain(args4, "3 2 1 0 -1", "-1 0 1 2 3", 1.0);
    }

    /**
     * Rather than writing the same code repeatedly, we call a function to run
     * the same code each time. The function parameters change with each test
     * case.
     */
    @Test
    public void testCallingMainWithSingleValue() {
        String[] args1 = { "34" };
        checkCallingMain(args1, "34", "34", 34);
    }

    /**
     * This helper function runs the TempMedian for a single input, and then
     * checks the results.
     * 
     * @param testParameters
     *            the arguments to the TempMedian.main() method
     * @param expectedTemperatures
     *            expected temperatures line of the result
     * @param expectedSortedTemperatures
     *            expected sorted temperatures line of the result
     * @param expectedMedianTemperature
     *            expected median temperature line of the result
     */
    private void checkCallingMain(String[] testParameters, String expectedTemperatures, String expectedSortedTemperatures, double expectedMedianTemperature) {

        // Call TempMedian.main() and check the output is as expected.
        String result = captureOutputOfMain(testParameters);

        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check we have exactly 3 result lines
        assertEquals("Number of result lines", 3, resultLines.length);

        // Convert the String results to doubles
        double medianTemperature = Double.parseDouble(resultLines[2]);

        assertEquals(expectedTemperatures, resultLines[0]);
        assertEquals(expectedSortedTemperatures, resultLines[1]);
        // Check the median value is correct (within and error value of 0.01)
        assertEquals(expectedMedianTemperature, medianTemperature, 0.01);

    }

}
