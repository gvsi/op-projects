public class Interval {
	private double left;
	private double right;
	
	public double getLeft() {
		return left;
	}
	
	public double getRight() {
		return right;
	}
	
	public Interval(double left, double right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean doesContain(double x) {
			return !isEmpty() && x >= left && x <= right;
	}
	
	public boolean isEmpty() {
		return left > right;
	}
	
	public boolean intersects(Interval b) {
		return !isEmpty() && !b.isEmpty() && b.getLeft() <= right && left <= b.getRight();
	}
	
	public String toString() {
		if (!isEmpty())
			return String.format("Interval: [%.1f, %.1f]", left, right);
		else
			return "Interval: (EMPTY)";
	}
	
	public static void main (String[] args) {
		Interval interval0 = new Interval(2.0, 1.0);
		System.out.println(interval0);
		
		Interval interval1 = new Interval(1.0, 2.0);
		System.out.println(interval1);
	}
}
