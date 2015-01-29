import java.util.HashMap;

public class WordCounter {
	HashMap<Integer, Integer> freqDist;
	
	public WordCounter(String[] tokens) {
		wordLengthFreq(tokens);
	}
	
	public void wordLengthFreq(String[] tokens) {
		freqDist = new HashMap<Integer, Integer>();
		for (String token : tokens) {
			Integer freq = freqDist.get(token.length());
			freqDist.put(token.length(), freq == null ? 1 : freq + 1);
		}
	}
	
	public HashMap<Integer, Integer> getFreqDist() {
		return freqDist;
	}
	
	public int maxVal() {
		int max = 0;
		for (int freq : freqDist.keySet())
			if (freqDist.get(freq) > max)
				max = freqDist.get(freq);
		return max;
	}
	
	public int maxKey() {
		int max = 0;
		for (int freq : freqDist.keySet())
			if (freq > max)
				max = freq;
		return max;
	}
	
	public double[] map2array() {
		int maxVal = maxVal();
		int maxKey = maxKey();
		
		if (maxVal == 0) {
			return new double[0];
		}
		double[] arr = new double[maxKey + 1];
		
		for (Integer key : freqDist.keySet()) {
			arr[key] = (double) freqDist.get(key) * 100 / maxVal;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer("melville-moby_dick.txt");
		String[] tokens = tokenizer.getTokens();

		WordCounter wordCounter = new WordCounter(tokens);
		System.out.println(wordCounter.getFreqDist());
		double[] points = wordCounter.map2array();

		int n = points.length;
		StdDraw.clear();
		StdDraw.setXscale(0, n - 1);
		StdDraw.setYscale(0, 100);
		StdDraw.setPenRadius(0.5 / n);
		for (int i = 0; i < n; i++) {
		    StdDraw.line(i, 0, i, points[i]);
		}

	}
}
