public class Mode {
	public static void main (String[] args) {
		int[] dataset = new int[args.length];

		// Creates dataset
		for (int i = 0; i < args.length; i++) {
			dataset[i] = Integer.parseInt(args[i]);
		}
		
		// Creates count array
		int[] count = new int[10];
		for (int i = 0; i < 10; i++) {
			count[i] = 0;
		}
		
		// Counts numbers
		for (int num : dataset) {
			count[num]++;
		}
		
		// Prints table
		for (int i = 0; i < 10; i++) {
			System.out.print("[" + i + "s: " + count[i] + "]");
			if (count[i] > 0) {
				System.out.print(" ");
				for (int j = 0; j < count[i]; j++) System.out.print(".");
			}
			System.out.print("\n");
		}
		// Calculates and prints mode
		int mode = 0;
		for (int i = 1; i < 10; i++) {
			if (count[i] > count[mode]) mode = i;
		}
		System.out.print("Mode: " + mode);
	}
}
