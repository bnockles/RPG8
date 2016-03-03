package project.save;

import java.util.Hashtable;

public class Save {
	
	private Hashtable t = new Hashtable();
	private int fileNum;
	
	public Save(int fileNum) {
		this.fileNum = fileNum;
		t = SaveUtility.doLoad(fileNum);
	}
	
	public void saveData() {
		SaveUtility.doSave(t, fileNum);
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
}
