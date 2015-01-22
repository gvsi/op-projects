import java.util.Arrays;

public class TempMedian {
	public static void main (String[] args) {
		int[] temps = new int[args.length];
		temps[0] = Integer.parseInt(args[0]);
		for (int i = 1; i < args.length; i++) {
			if (args[i].equals(".")) {
				temps[i] = temps[i-1];
			} else if (args[i].equals("+")) {
				temps[i] = temps[i-1] + 1;
			} else if (args[i].equals("-")) {
				temps[i] = temps[i-1] - 1;
			}
 		}
		
		// prints array elements separated by space
		String delim = "";
		for (int temp : temps) {
		    System.out.print(delim + temp);
		    delim = " ";
		}
		System.out.print("\n");
		
		// sorts the array
		Arrays.sort(temps);
		
		// prints array elements separated by space
		delim = "";
		for (int temp : temps) {
		    System.out.print(delim + temp);
		    delim = " ";
		}
		System.out.print("\n");
		
		if (temps.length % 2 != 0) {
			System.out.println((double)temps[temps.length / 2]);
		} else {
			System.out.println((temps[temps.length / 2 - 1] + temps[temps.length / 2]) / 2.0);
		}
	}
}
