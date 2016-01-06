package project.save;

public class SaveUtility {

	public static String getTextFromTags(String s, String tag){
		String startTag = "<"+tag+">";
		String endTag = "</"+tag+">";
		return s.substring(s.indexOf(startTag)+startTag.length(), s.indexOf(endTag));
	}
	
	public static boolean getBooleanFromTag(String s, String tag){
		return Boolean.parseBoolean(getTextFromTags(s, tag));
	}
	
	public static long getLongFromTag(String s, String tag){
		return Long.parseLong(getTextFromTags(s, tag));
	}
	
	public static int getIntFromTag(String s, String tag){
		return Integer.parseInt(getTextFromTags(s, tag));
	}
	
	
}
