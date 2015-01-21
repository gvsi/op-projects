public class MeanVariance {
	public static void main (String[] args) {
		double mean = 0;
		for (int i = 0; i < args.length; i++) {
			mean += Double.parseDouble(args[i]);	
		}
		mean = mean / args.length;
		System.out.println(mean);

		double variance = 0;
		for (int i = 0; i < args.length; i++) {
			variance += Math.pow((Double.parseDouble(args[i]) - mean),2);
		}
		variance = variance / args.length;
		System.out.println(variance);
	}
}
