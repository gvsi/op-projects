import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test Mode behaves as expected
 * 
 */
public class ModeTest {

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
            Mode.main(args);
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
        String[] args1 = { "1", "1", "1" };
        String[] expectedResult1 = {
                "[0s: 0]",
                "[1s: 3] ...",
                "[2s: 0]",
                "[3s: 0]",
                "[4s: 0]",
                "[5s: 0]",
                "[6s: 0]",
                "[7s: 0]",
                "[8s: 0]",
                "[9s: 0]",
                "Mode: 1"
                };
        checkCallingMain(args1, expectedResult1);

        String[] args2 = { "1", "1", "1", "7", "7", "8", "3", "9", "8", "8", "8" };
        String[] expectedResult2 = {
                "[0s: 0]",
                "[1s: 3] ...",
                "[2s: 0]",
                "[3s: 1] .",
                "[4s: 0]",
                "[5s: 0]",
                "[6s: 0]",
                "[7s: 2] ..",
                "[8s: 4] ....",
                "[9s: 1] .",
                "Mode: 8"
                };
        checkCallingMain(args2, expectedResult2);
    }

    /**
     * This helper function runs the Mode for a single input, and then
     * checks the results.
     * 
     * @param testParameters
     *            the arguments to the Mode.main() method
     * @param expectedResultLines
     *            array of expected result lines
     */
    private void checkCallingMain(String[] testParameters, String[] expectedResultLines) {
        // Call Mode.main() and check the output is as expected.
        String result = captureOutputOfMain(testParameters);

        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check the values are correct
        assertArrayEquals(expectedResultLines, resultLines);
    }

    
}
