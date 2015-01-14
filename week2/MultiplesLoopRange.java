public class MultiplesLoopRange {
	public static void main (String[] args) {
		int start = Integer.parseInt(args[0]);
		int stop = Integer.parseInt(args[1]);
		int multiple = Integer.parseInt(args[2]);

		if (start <= stop) {
			for (int i = start; i <= stop; i++) {
				if (i % multiple == 0) {
					System.out.print(i + " ");
				}
			}
			System.out.print("\n");
		} else {
			for (int i = start; i >= stop; i--) {
				if (i % multiple == 0) {
					System.out.print(i + " ");
				}
			}
			System.out.print("\n");
		}
	}
}
