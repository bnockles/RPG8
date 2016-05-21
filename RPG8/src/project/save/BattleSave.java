package project.save;

import java.util.ArrayList;

public class BattleSave extends Save{
	public static void saveData(String id, ArrayList<Integer> data) {
		t.put(id, data);
	}
	
	public static ArrayList<Integer> getIntArrayList(String id) {
		return (ArrayList<Integer>) t.get(id);
	}
}
