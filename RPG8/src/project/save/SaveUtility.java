package project.save;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class SaveUtility {
	
	public static int numOfSaveFiles = 3;
	
	public static Hashtable doLoad(int fileNum) {
		System.out.println("Loading...");
		
		Hashtable h = new Hashtable();
		
		try {
			// Creating File/Object input stream
			FileInputStream fileIn = new FileInputStream("Save" + fileNum);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Loading Hashtable Object
			h = (Hashtable)in.readObject();

			// Closing all input streams
			in.close();
			fileIn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) {
			System.out.println("No File.");
			System.out.println("Creating default save file.");
			h = doDefaultSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		return h;
	}
	
	private void doSave(Hashtable h, int fileNum) {
		System.out.println("Saving...\n");
		
		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream("Save" + fileNum);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			// Writing Hashtable Object
			out.writeObject(h);

			// Closing all output streams
			out.close();
			fileOut.close();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static Hashtable doDefaultSave() {
		return null;
	}
	
	// Old SaveUtility Code
	/*
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
	*/
}
