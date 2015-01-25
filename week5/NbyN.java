public class NbyN {
	public static int[][] nbyn(int n) {
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) array[i][j] = i;
				else array[i][j] = 0;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[][] array = nbyn(10);
		for (int i = 0; i < array.length; i++) {
			String delim = "";
			for (int j = 0; j < array.length; j++) {
				System.out.print(delim + array[i][j]);
				delim = " ";
			}
			System.out.print("\n");
		}
	}
}