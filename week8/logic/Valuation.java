package logic;

import java.util.HashMap;

public class Valuation {

    HashMap<PropVar, Boolean> val = new HashMap<PropVar, Boolean>();

    public boolean get(PropVar propVar) {
        return val.get(propVar);
    }

    public void put(PropVar propVar, boolean tv) {
        val.put(propVar, tv);
    }
}