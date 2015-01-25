public class SplitPathName {
	public static String[] splitPath(String s) {
		String[] array = new String[4];
		
		if (s.lastIndexOf("/") != -1) {
			array[0] = s.substring(0, s.lastIndexOf("/") + 1);
			array[1] = s.substring(s.lastIndexOf("/") + 1);
			if (s.lastIndexOf(".") != -1) {
				array[2] = s.substring(s.lastIndexOf("/") + 1, s.lastIndexOf("."));
				array[3] = s.substring(s.lastIndexOf("."));
			} else {
				array[2] = s.substring(s.lastIndexOf("/"));
				array[3] = "";
			}
		} else {
			array[0] = "";
			array[1] = s;
			if (s.lastIndexOf(".") != -1) {
				array[2] = s.substring(0, s.lastIndexOf("."));
				array[3] = s.substring(s.lastIndexOf("."));
			} else {
				array[2] = s;
				array[3] = "";
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		for (String arg : args) {
			String[] split = splitPath(arg);
			System.out.printf("File: %s Type: %s [%s]\n", split[1], split[3], split[0]);
		}
	}
}
