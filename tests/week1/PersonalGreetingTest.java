import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test PersonalGreeting behaves as expected
 * 
 */
public class PersonalGreetingTest {

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
            PersonalGreeting.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testCallingMain() {
        // Call PersonalGreeting.main() and check the output is as expected.
        String[] args1 = { "John", "Smith" };
        assertEquals("Hello John Smith", captureOutputOfMain(args1));

        String[] args2 = { "Joe", "Bloggs" };
        assertEquals("Hello Joe Bloggs", captureOutputOfMain(args2));
    }
}
