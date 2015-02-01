package logic;

public class NotWff extends Wff {

    private Wff wff;
    private Operator op;

    public NotWff(Wff prop) {
        this.wff = prop;
        this.op = Operator.NEG;
    }

    @Override
    public boolean eval(Valuation val) {
        return !(wff.eval(val));
    }

    @Override
    public String toString() {
        String s = String.format("%s%s", op, wff);
        return s;
    }

}