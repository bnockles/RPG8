package project.save;

/*
 * @author Wilson Wat
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class SaveUtility {
	
	/*
	public static final int NAME_0 = 0;
	public static final int NAME_1 = 1;
	public static final int NAME_2 = 2;
	
	public static final int NUM_OF_SAVE_FILES = 3;
	*/
	
	public static Save getSaveFile(int choice) {
		/*
		if (choice < NUM_OF_SAVE_FILES && choice > -1) {
			if (choice == NAME_0) return new Save(choice, "Alice");
			if (choice == NAME_1) return new Save(choice, "Bob");
			if (choice == NAME_2) return new Save(choice, "Eve");
		}
		
		System.out.printf("I'm sorry, but there are only %d save slots available\n", NUM_OF_SAVE_FILES);
		return null;
		*/
		return new Save();
	}
	
	public static void saveData() {
		System.out.println("Saving File");
		
		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream("Save");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			// Writing Hashtable Object
			out.writeObject(t);

			// Closing all output streams
			out.close();
			fileOut.close();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
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
			// h = doDefaultSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		return h;
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
