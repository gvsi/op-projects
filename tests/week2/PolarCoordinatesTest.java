import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test PolarCoordinates behaves as expected
 * 
 */
public class PolarCoordinatesTest {

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
            PolarCoordinates.main(args);
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
    public void testCallingMain() {
        // Call PolarCoordinates.main() and check the output is as expected.
        String[] args1 = { "1.0", "1.0" };
        checkCallingMain(args1, 1.41421, 0.78539);

        String[] args2 = { "1.0", "0.0" };
        checkCallingMain(args2, 1.0, 0.0);

        String[] args3 = { "0.0", "1.0" };
        checkCallingMain(args3, 1.0, 1.57079);

        String[] args4 = { "0.0", "-1.0" };
        checkCallingMain(args4, 1.0, -1.57079);

        String[] args5 = { "0.0", "-2.0" };
        checkCallingMain(args5, 2.0, -1.57079);
    }

    /**
     * This helper function runs the PolarCoordinates for a single input, and
     * then checks the results.
     * 
     * @param testParameters
     *            the arguments to the PolarCoordinates.main() method
     * @param expectedR
     *            expected R value of the result
     * @param expectedTheta
     *            expected theta value of the result
     */
    private void checkCallingMain(String[] testParameters, double expectedR, double expectedTheta) {
        // Call QuadraticSolver.main() and check the output is as expected.
        String result = captureOutputOfMain(testParameters);

        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check we have exactly 2 result lines
        assertEquals("Number of result lines", 2, resultLines.length);

        // Convert the String results to doubles
        double r = Double.parseDouble(resultLines[0]);
        double theta = Double.parseDouble(resultLines[1]);

        // Check the values are correct (within and error value of 0.0001)
        assertEquals(expectedR, r, 0.0001);
        assertEquals(expectedTheta, theta, 0.0001);
    }

}
