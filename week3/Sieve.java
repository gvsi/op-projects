import java.util.Arrays;

public class Sieve {
	public static void main (String[] args) {
		int n = 20;
		int[] sieved_numbers = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			sieved_numbers[i] = i + 2;
		}
		//System.out.println(Arrays.toString(sieved_numbers));
		int p = 2;
		String delim = "";
		
		while (p < n) {
			// Prints p
			System.out.print(delim + p);
			
			// Sets all multiples to 0
			for (int i = 0; i < n - 1; i++) {
				if (sieved_numbers[i] % p == 0) sieved_numbers[i] = 0;
			}
			
			// Finds new value for p
			int temp = p;
			for (int i = 0; i < n - 1; i++) {
				if (sieved_numbers[i] > p) {
					p = sieved_numbers[i];
					break;
				}
			}
			if (temp == p) p = n + 1;
			
			delim = " ";
		}
	}
}