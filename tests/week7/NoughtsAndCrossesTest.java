import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NoughtsAndCrossesTest {
    public final int ___ = 0;
    public final int _O_ = 1;
    public final int _X_ = 2;

    @Test
    public void testNoughtsWin1() {
        int[][] table = { { ___, ___, _O_ }, { ___, ___, _O_ }, { ___, ___, _O_ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _O_);
    }

    @Test
    public void testNoughtsWin2() {
        int[][] table = { { _O_, ___, ___ }, { ___, _O_, ___ }, { ___, ___, _O_ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _O_);
    }

    @Test
    public void testNoughtsWin3() {
        int[][] table = { { ___, ___, ___ }, { _O_, _O_, _O_ }, { ___, ___, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _O_);
    }

    @Test
    public void testCrossesWin1() {
        int[][] table = { { ___, ___, ___ }, { _X_, _X_, _X_ }, { ___, ___, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _X_);
    }

    @Test
    public void testCrossesWin2() {
        int[][] table = { { ___, _X_, ___ }, { ___, _X_, ___ }, { ___, _X_, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _X_);
    }

    @Test
    public void testCrossesWin3() {
        int[][] table = { { ___, ___, _X_ }, { ___, _X_, ___ }, { _X_, ___, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertFalse(nc.isDraw());
        assertTrue(nc.whoWon() == _X_);
    }

    @Test
    public void testDraw1() {
        int[][] table = { { ___, ___, ___ }, { ___, ___, ___ }, { ___, ___, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertTrue(nc.isDraw());

    }

    @Test
    public void testDraw2() {
        int[][] table = { { _X_, _O_, _X_ }, { ___, _X_, _O_ }, { ___, ___, ___ }, };
        NoughtsAndCrosses nc = new NoughtsAndCrosses(table);

        assertTrue(nc.isDraw());
    }

}