package logic;

public class IfWff extends BinaryWff {
	public IfWff(Wff left, Wff right) {
		super(left, right);
		setOp(Operator.IF);
	}
	
	@Override
    public boolean eval(Valuation val) {
        return (!(getLeft().eval(val)) || getRight().eval(val));
    }
}