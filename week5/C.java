public class C {
	public static void main(String y[]) {
		int x = Integer.parseInt(y[0]);
		int z = Integer.parseInt(y[1]);
		if (x <= z) {
			for (int i = x; i <= z; i++) {
				if (i % 2 == 0) {
					System.out.print(i + " ");
				}
			}
		} else {
			System.out.println(x + " cannot be greater than " + z);
		}
	}
}