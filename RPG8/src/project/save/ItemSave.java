package project.save;

import java.util.ArrayList;

public class ItemSave extends Save{
	
	public static void saveData(String id, ArrayList<String> data) {
		t.put(id, data);
	}
	
	public static ArrayList<String> getStringArrayList(String id) {
		return (ArrayList<String>) t.get(id);
	}
}
