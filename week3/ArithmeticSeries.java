public class ArithmeticSeries {
	public static void main (String[] args) {
		int i = Integer.parseInt(args[0]);
		int result = 0;
		while (i > 0) {
			result += i;
			i--;
		}
		System.out.println(result);
	}
}
