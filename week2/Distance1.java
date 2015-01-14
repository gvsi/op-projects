public class Distance1 {
	public static void main (String[] args) {
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);

		System.out.println(Math.max(first, second) - Math.min(first, second));
	}
}