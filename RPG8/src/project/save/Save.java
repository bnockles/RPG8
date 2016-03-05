package project.save;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * @author Wilson Wat
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Save {
	
	private Hashtable t = new Hashtable();
	private int fileNum;
	private String name;
	
	public Save(int fileNum, String name) {
		this.fileNum = fileNum;
		this.name = name;
		t = SaveUtility.doLoad(fileNum);
	}
	
	public void saveData() {
		System.out.printf("Saving %s\'s File...\n\n", name);
		
		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream("Save" + fileNum);
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
	
	// Save method
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
	
	public void saveData(String id, String data) {
		t.put(id, data);
	}
	
	public void saveData(String id, ArrayList<Integer> data) {
		t.put(id, data);
	}
	
	// Read methods
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
	
	public String getString(String id) {
		return t.get(id).toString();
	}
	
	public ArrayList<Integer> getIntArrayList(String id) {
		return (ArrayList<Integer>) t.get(id);
	}
}
