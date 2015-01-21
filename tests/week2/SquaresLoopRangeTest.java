import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test SquaresLoopRange behaves as expected
 * 
 */
public class SquaresLoopRangeTest {

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
            SquaresLoopRange.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void test1() {
        // Call SquaresLoopRange.main() and check the output is as expected.
        String[] args = { "1", "10" };
        assertEquals("1 4 9 16 25 36 49 64 81 100", captureOutputOfMain(args));
    }

    @Test
    public void test2() {
        // Call SquaresLoopRange.main() and check the output is as expected.
        String[] args = { "5", "10" };
        assertEquals("25 36 49 64 81 100", captureOutputOfMain(args));
    }

    @Test
    public void test3() {
        // Call SquaresLoopRange.main() and check the output is as expected.
        String[] args = { "5", "7" };
        assertEquals("25 36 49", captureOutputOfMain(args));
    }

    @Test
    public void test4() {
        // Call SquaresLoopRange.main() and check the output is as expected.
        String[] args = { "7", "5" };
        assertEquals("Start-limit greater than stop-limit!", captureOutputOfMain(args));
    }

    @Test
    public void test5() {
        // Call SquaresLoopRange.main() and check the output is as expected.
        String[] args = { "5", "5" };
        assertEquals("25", captureOutputOfMain(args));
    }

}
