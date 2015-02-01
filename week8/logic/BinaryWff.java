package logic;

public abstract class BinaryWff extends Wff {
	private Wff left;
	private Wff right;
	private Operator op;
	
	public BinaryWff(Wff left, Wff right) {
		this.left = left;
		this.right = right;
	}
	
	public void setOp(Operator op) {
		this.op = op;
	}
	
	public Operator getOp() {
		return op;
	}
	
	public Wff getLeft() {
		return left;
	}
	
	public Wff getRight() {
		return right;
	}
	
	public String toString() {
		return "(" + left + " " + op + " " + right + ")";
	}
}
