public class OneTimePadEncipher {

    public static int charToInt(char l) {
      // ADD CODE HERE
      // Should convert a character to an integer, for example 'a' -> 0, 'b' -> 1
    	return (int) Character.toUpperCase(l) - 65;
    }

    public static char intToChar(int i) {
      // ADD CODE HERE
      // Should convert an integer to a character, for example 0 -> 'a', b -> '1'
      // it should always return lower case chae
    	return (char) (i + 97);
    }

    public static boolean isAlpha(char c) {
      return charToInt(c) >= 0 && charToInt(c) <= 25;
    }

    public static String encipher(String original, String onetimepad) {
    	original = original.toUpperCase();
    	onetimepad = onetimepad.toUpperCase();
    	char[] array = new char[original.length()];
    	for (int i = 0; i < original.length(); i++) {
    		if (isAlpha(original.charAt(i)))
    			array[i] = intToChar((charToInt(original.charAt(i)) + charToInt(onetimepad.charAt(i))) % 26);
    		else
    			array[i] = original.charAt(i);
    	}
    	return String.valueOf(array);
    }


    public static void main(String[] args) {
      String ciphertext = encipher("IS THIS SECURE", "KEEPMEVERYVERYSAFE");
      System.out.print(ciphertext);
    }

}