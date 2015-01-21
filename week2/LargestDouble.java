public class LargestDouble {
	public static void main (String[] args) {
		double first = Double.parseDouble(args[0]);
		double second = Double.parseDouble(args[1]);
		
		System.out.println(Math.max(first, second));
	}
}