import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test BooleanExpr behaves as expected
 * 
 */
public class BooleanExprTest {

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
            BooleanExpr.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call BooleanExpr.main() and check the output is as expected.
        String[] args1 = { "True", "True" };
        assertEquals("a: true\nb: true\nphi: true", captureOutputOfMain(args1));

        String[] args2 = { "False", "True" };
        assertEquals("a: false\nb: true\nphi: true", captureOutputOfMain(args2));

        String[] args3 = { "True", "False" };
        assertEquals("a: true\nb: false\nphi: true", captureOutputOfMain(args3));

        String[] args4 = { "False", "False" };
        assertEquals("a: false\nb: false\nphi: true", captureOutputOfMain(args4));
    }
}
