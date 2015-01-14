public class ImQuadraticSolver {
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);

		if (a == 0) {
			System.out.println("A = 0. Cannot solve equation.");
		} else if (b * b - 4 * a * c > 0) {
			System.out.println((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
			System.out.println((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		} else {
			System.out.println(-b / (2 * a) + " + " + Math.sqrt(Math.abs(b * b - 4 * a * c)) / (2 * a) + "i" );
		}
	}
}