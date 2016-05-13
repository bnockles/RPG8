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

public abstract class Save {
	
	protected Hashtable t;
	private String name;

	public Save(String name) {
		this.name = name;
		this.t = doLoad();
	}
	
	public void saveData() {
		System.out.printf("Saving %s.save\n", name);
		
		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream(name + ".save");
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
	
	private Hashtable doLoad() {
		System.out.printf("Loading %s.save\n", name);
		
		Hashtable h = new Hashtable();
		
		try {
			// Creating File/Object input stream
			FileInputStream fileIn = new FileInputStream(name + ".save");
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
	
	// Save method
	public void saveData(String id, String data) {
		t.put(id, data);
	}
	
	public void saveData(String id, int data) {
		t.put(id, data);
	}
	
	public void saveData(String id, long data) {
		t.put(id, data);
	}
	
	public void saveData(String id, double data) {
		t.put(id, data);
	}
	
	public void saveData(String id, boolean data) {
		t.put(id, data);
	}
	
	// Read methods
	public String getString(String id) {
		return t.get(id).toString();
	}
	
	public int getInt(String id) {
		return (int)t.get(id);
	}
	
	public long getLong(String id) {
		return (long)t.get(id);
	}
	
	public double getDouble(String id) {
		return (double)t.get(id);
	}
	
	public boolean getBoolean(String id) {
		return (boolean)t.get(id);
	}
	
}
