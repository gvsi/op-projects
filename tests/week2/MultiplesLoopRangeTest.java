import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test MultiplesLoopRange behaves as expected
 * 
 */
public class MultiplesLoopRangeTest {

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
            MultiplesLoopRange.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void test1() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "1", "10", "1" };
        assertEquals("1 2 3 4 5 6 7 8 9 10", captureOutputOfMain(args));
    }

    @Test
    public void test2() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "5", "10", "1" };
        assertEquals("5 6 7 8 9 10", captureOutputOfMain(args));
    }

    @Test
    public void test3() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "5", "7", "1" };
        assertEquals("5 6 7", captureOutputOfMain(args));
    }

    @Test
    public void test4() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "7", "5", "1" };
        assertEquals("7 6 5", captureOutputOfMain(args));
    }

    @Test
    public void test5() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "5", "5", "1" };
        assertEquals("5", captureOutputOfMain(args));
    }

    @Test
    public void test6() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "5", "5", "5" };
        assertEquals("5", captureOutputOfMain(args));
    }

    @Test
    public void test7() {
        // Call MultiplesLoopRange.main() and check the output is as expected.
        String[] args = { "5", "10", "2" };
        assertEquals("6 8 10", captureOutputOfMain(args));
    }

}
