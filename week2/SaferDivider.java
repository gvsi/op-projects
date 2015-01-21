public class SaferDivider {
	public static void main (String[] args) {
		double numerator = Double.parseDouble(args[0]);
		double denominator = Double.parseDouble(args[1]);
		if (denominator != 0) {
			System.out.println(numerator / denominator);
		} else {
			System.out.println("I can't divide by zero!");
		}
	}
}