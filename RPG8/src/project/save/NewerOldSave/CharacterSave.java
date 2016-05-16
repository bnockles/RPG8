package project.save;

import java.util.ArrayList;

public class CharacterSave extends Save {
	
	public CharacterSave(String name) {
		super(name);
	}
	
	public void saveData(String id, ArrayList<Integer> data) {
		t.put(id, data);
	}
	
	public ArrayList<Integer> getIntArrayList(String id) {
		return (ArrayList<Integer>) t.get(id);
	}
}
