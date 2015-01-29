public class Tokenizer {
	private String[] tokens;
	
	public Tokenizer() {
		tokens = new String[0];
	}
	
	public Tokenizer(String fname) {
		tokensFromFile(fname);
	}
	
	public void tokensFromFile(String fname) {
		In file = new In(fname);
		String s = file.readAll();
		tokenize(s);
	}
	
	public void tokenize(String str) {
		tokens = str.split("\\W+");
	}
	
	public String[] getTokens() {
		return tokens;
	}
	
	public int getNumberTokens() {
		return tokens.length;
	}
}
