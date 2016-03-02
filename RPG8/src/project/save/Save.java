package project.save;

import java.util.Hashtable;

public class Save {
	
	private Hashtable t = new Hashtable();
	
	public Save(int fileNum) {
		t = SaveUtility.doLoad(fileNum);
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
	
	public void saveData(String id, String data) {
		t.put(id, data);
	}
}
