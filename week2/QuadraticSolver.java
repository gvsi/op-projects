public class QuadraticSolver {
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);

		System.out.println((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		System.out.println((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
	}
}