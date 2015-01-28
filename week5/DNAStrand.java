public class DNAStrand {
	private String strand;
	public DNAStrand(String dna) {
		strand = dna;
	}
	
	public boolean isValidDNA() {
		if (strand.length() == 0) return false;
		for (int i = 0; i < strand.length(); i++) {
			char base = strand.charAt(i);
			if (base != 'A' && base != 'T' && base != 'C' && base != 'G') {
				return false;
			}
		}
		return true;
	}
	
	public String complementWC() {
		char[] complement = new char[strand.length()];
		for (int i = 0; i < strand.length(); i++) {
			switch (strand.charAt(i)) {
			case 'A':
				complement[i] = 'T';
				break;
			case 'T':
				complement[i] = 'A';
				break;
			case 'C':
				complement[i] = 'G';
				break;
			case 'G':
				complement[i] = 'C';
				break;
			}
		}
		return String.valueOf(complement);
	}
	
	public String palindromeWC() {
		String complement = complementWC();
		int n = complement.length();
		StringBuilder palindrome = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			palindrome.append(complement.charAt(n - 1 - i));
		}
		return palindrome.toString();
	}
	
	public boolean containsSequence(String seq) {
		for (int i = 0; i <= strand.length() - seq.length(); i++) {
			if (strand.charAt(i) == seq.charAt(0)) {
				
				if (seq.length() == 1) 
					return true;
				else
					for (int j = 1; j < seq.length(); j++) {
						if (strand.charAt(i + j) != seq.charAt(j))
							break;
						
						// returns true if it hasn't broken yet and the last characters are equal
						if (j == seq.length() - 1 && strand.charAt(i + j) == seq.charAt(j)) 
							return true; 
					}
			}
		}
		return false;
	}
	
	public String toString() {
		return strand;
	}
	
	public static void main(String[] args) {
		DNAStrand myDNA = new DNAStrand("AGTCGA");
		String seq = "A";
		System.out.println(myDNA.isValidDNA());
		System.out.println(myDNA.complementWC());
		System.out.println(myDNA.palindromeWC());
		System.out.println(myDNA.containsSequence(seq));
	}
}
