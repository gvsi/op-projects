import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test MeanVariance behaves as expected
 * 
 */
public class MeanVarianceTest {

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
            MeanVariance.main(args);
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
    public void testCallingMainWithSingleValueInputs() {
        String[] args1 = { "0.0" };
        checkCallingMain(args1, 0.0, 0);

        String[] args2 = { "1.5" };
        checkCallingMain(args2, 1.5, 0);

        String[] args3 = { "-100.23" };
        checkCallingMain(args3, -100.23, 0);
    }

    /**
     * Rather than writing the same code repeatedly, we call a function to run
     * the same code each time. The function parameters change with each test
     * case.
     */
    @Test
    public void testCallingMainWithSeveralIdenticalValueInputs() {
        String[] args1 = { "0.0", "0.0", "0.0", "0.0" };
        checkCallingMain(args1, 0.0, 0);

        String[] args2 = { "1.5", "1.5", "1.5" };
        checkCallingMain(args2, 1.5, 0);

        String[] args3 = { "-100.23", "-100.23" };
        checkCallingMain(args3, -100.23, 0);
    }

    /**
     * Rather than writing the same code repeatedly, we call a function to run
     * the same code each time. The function parameters change with each test
     * case.
     */
    @Test
    public void testCallingMainGeneralCase() {
        String[] args1 = { "1.0", "3.0", "1.0", "3.0" };
        checkCallingMain(args1, 2.0, 1.0);

        String[] args2 = { "1.0", "2.0", "3.4", "2.3", "5.6", "3.4", "2.1" };
        checkCallingMain(args2, 2.828, 1.882);
    }

    /**
     * This helper function runs the MeanVariance for a single input, and then
     * checks the results.
     * 
     * @param testParameters
     *            the arguments to the MeanVariance.main() method
     * @param expectedMean
     *            expected first line of the result
     * @param expectedVariance
     *            expected second line of the result
     */
    private void checkCallingMain(String[] testParameters, double expectedMean, double expectedVariance) {
        // Call MeanVariance.main() and check the output is as expected.
        String result = captureOutputOfMain(testParameters);

        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check we have exactly 2 result lines
        assertEquals("Number of result lines", 2, resultLines.length);

        // Convert the String results to doubles
        double result1 = Double.parseDouble(resultLines[0]);
        double result2 = Double.parseDouble(resultLines[1]);

        // Check the values are correct (within and error value of 0.01)
        assertEquals(expectedMean, result1, 0.01);
        assertEquals(expectedVariance, result2, 0.01);
    }

}
