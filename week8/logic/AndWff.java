package logic;

public class AndWff extends BinaryWff {
	public AndWff(Wff left, Wff right) {
		super(left, right);
		setOp(Operator.AND);
	}
	
	@Override
    public boolean eval(Valuation val) {
        return (getLeft().eval(val) && getRight().eval(val));
    }
}