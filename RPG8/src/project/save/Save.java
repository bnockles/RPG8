package project.save;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

/*
 * @author Wilson Wat
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Save {
	
	protected static Hashtable t;
	private static String name;
	private static int currentSave = 0;
	private static boolean newFile = false;
	
	static {
		name = "Save" + currentSave;
		t = doLoad();
	}
	
	public static void chooseSave(int option) {
		if (option >= 0 && option < 4)
			currentSave = option;
		name = "Save" + currentSave;
		t = doLoad();
		TestSave.test(newFile);
		newFile = false;
	}
	
	public static void saveData() {
		System.out.printf("Saving %s\n", name);
		
		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream(name);
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
	
	private static Hashtable doLoad() {
		System.out.printf("Loading %s\n", name);
		
		Hashtable h = new Hashtable();
		
		try {
			// Creating File/Object input stream
			FileInputStream fileIn = new FileInputStream(name);
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
			newFile = true;
			// h = doDefaultSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		return h;
	}
	
	// Save method
	public static void saveData(String id, String data) {
		t.put(id, data);
	}
	
	public static void saveData(String id, int data) {
		t.put(id, data);
	}
	
	public static void saveData(String id, long data) {
		t.put(id, data);
	}
	
	public static void saveData(String id, double data) {
		t.put(id, data);
	}
	
	public static void saveData(String id, boolean data) {
		t.put(id, data);
	}
	
	// Read methods
	public static String getString(String id) {
		if (t.get(id) == null) return null;
		return t.get(id).toString();
	}
	
	public static int getInt(String id) {
		if (t.get(id) == null) return 0;
		return (int)t.get(id);
	}
	
	public static long getLong(String id) {
		if (t.get(id) == null) return 0;
		return (long)t.get(id);
	}
	
	public static double getDouble(String id) {
		if (t.get(id) == null) return 0;
		return (double)t.get(id);
	}
	
	public static boolean getBoolean(String id) {
		if (t.get(id) == null) return false;
		return (boolean)t.get(id);
	}
	
}
