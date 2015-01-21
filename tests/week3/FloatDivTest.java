import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test FloatDiv behaves as expected
 * 
 */
public class FloatDivTest {

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
            FloatDiv.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call FloatDiv.main() and check the output is as expected.
        String[] args = { "26", "3" };
        String result = captureOutputOfMain(args);

        // Split the result into individual lines - there should be 3
        String[] resultLines = result.split("[\r\n]+");

        // Check we have exactly 3 result lines
        assertEquals("Number of result lines", 3, resultLines.length);

        // Check the values are correct
        assertEquals("Patient Age: 26", resultLines[0].trim());
        assertEquals("Days since bitten: 3", resultLines[1].trim());
        assertEquals("Dosage of antidote: 28.846mg", resultLines[2].trim());
    }

}
