public class PolarCoordinates {
	public static void main (String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		System.out.println(Math.sqrt(x*x+y*y));
		System.out.println(Math.atan2(y,x));
	}
}