public class AbsolutePath {
	public static String ensureAbsolute(String path) {
		if (path.indexOf("/") == 0) {
			return path;
		} else {
			String currentDir = System.getProperty("user.dir");
			return currentDir + "/" + path;
		}
	}
	
	public static String[] absoluteSplitPath(String s) {
		return SplitPathName.splitPath(ensureAbsolute(s));
	}
}