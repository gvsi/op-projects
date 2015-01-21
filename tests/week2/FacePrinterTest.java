import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test FacePrinter behaves as expected
 * 
 */
public class FacePrinterTest {

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
            FacePrinter.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call FacePrinter.main() and check the output is as expected.
        
        String result = captureOutputOfMain(null);
        // Split the result into individual lines
        String[] resultLines = result.split("[\r\n]+");

        // Check the individual lines of the result
        assertEquals("///", resultLines[0].trim());
        assertEquals("///////", resultLines[1].trim());
        assertEquals("| o o |", resultLines[2].trim());
        assertEquals("@|  n  |@", resultLines[3].trim());
        assertEquals("| ~~~ |", resultLines[4].trim());
        assertEquals("-----", resultLines[5].trim());
    }

}
