import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test SaferQuadraticSolver behaves as expected
 * 
 */
public class SaferQuadraticSolverTest {

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
            SaferQuadraticSolver.main(args);
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
    public void testCallingMainWithSafeValues() {
        String[] args1 = { "1.0", "-2", "1" };
        checkCallingMain(args1, 1.0, 1.0);

        String[] args2 = { "1.0", "-3", "2" };
        checkCallingMain(args2, 2.0, 1.0);

        String[] args3 = { "1.0", "0", "-1" };
        checkCallingMain(args3, 1.0, -1.0);
    }

    @Test
    public void testCallingMainWithAEquals0() {
        // Call SaferQuadraticSolver.main() with A = 0 and check the output is as expected.
        String[] args = { "0.0", "0", "-1" };
        assertEquals("A = 0. Cannot solve equation.", captureOutputOfMain(args));
    }

    @Test
    public void testCallingMainWithImaginaryRoots() {
        // Call SaferQuadraticSolver.main() with b^2 - 4ac < 0 and check the output is as expected.
        String[] args = { "1.0", "-2.0", "2.0" };
        assertEquals("Equation is not solvable for real x.", captureOutputOfMain(args));
    }

    /**
     * This helper function runs the SaferQuadraticSolver for a single input,
     * and then checks the results.
     * 
     * @param testParameters
     *            the arguments to the SaferQuadraticSolver.main() method
     * @param expectedFirstResult
     *            expected first line of the result
     * @param expectedSecondResult
     *            expected second line of the result
     */
    private void checkCallingMain(String[] testParameters, double expectedFirstResult, double expectedSecondResult) {
        // Call SaferQuadraticSolver.main() and check the output is as expected.
        String result = captureOutputOfMain(testParameters);

        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check we have exactly 2 result lines
        assertEquals("Number of result lines", 2, resultLines.length);

        // Convert the String results to doubles
        double result1 = Double.parseDouble(resultLines[0]);
        double result2 = Double.parseDouble(resultLines[1]);

        // Check the values are correct (within and error value of 0.0001)
        assertEquals(expectedFirstResult, result1, 0.0001);
        assertEquals(expectedSecondResult, result2, 0.0001);
    }

}
