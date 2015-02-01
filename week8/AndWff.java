
public class AndWff extends BinaryWff {
	public AndWff(PropVar left, PropVar right) {
		super(left, right);
		setOp(Operator.AND);
	}
}