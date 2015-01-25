public class OneTimePadDecipher {
	public static String decipher(String encipheredText, String onetimepad) {
		char[] array = new char[encipheredText.length()];
		for (int i = 0; i < encipheredText.length(); i++) {
			if (OneTimePadEncipher.isAlpha(encipheredText.charAt(i))) {
				int a = (OneTimePadEncipher.charToInt(encipheredText.charAt(i)) - OneTimePadEncipher.charToInt(onetimepad.charAt(i)));
				array[i] = OneTimePadEncipher.intToChar(a < 0 ? a + 26 : a);
			} else {
				array[i] = encipheredText.charAt(i);
			}
		}
		return String.valueOf(array).toUpperCase();
	}
	
	public static void main (String args[]) {
		System.out.println(decipher("eqnvz", "XMCKL"));
	}
}