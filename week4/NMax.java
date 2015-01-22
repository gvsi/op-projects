public class NMax {
	
	public static int max (int a, int b, int c) {
		return Math.max(Math.max(a,b), c);
	}
	
	public static double max (double a, double b, double c) {
		return Math.max(Math.max(a,b), c);
	}
	
	public static void main (String[] args) {
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		
		System.out.println(max(a, b, c));
	}
}