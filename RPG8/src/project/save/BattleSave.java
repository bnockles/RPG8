package project.save;

import java.util.ArrayList;

import project.battles.EnemyLogEntry;

public class BattleSave extends Save{
	public static void saveData(String id, ArrayList<Integer> data) {
		t.put(id, data);
	}
	
	public static ArrayList<Integer> getIntArrayList(String id) {
		return (ArrayList<Integer>) t.get(id);
	}
	
	public static void saveEnemyLogData(String id, ArrayList<EnemyLogEntry> eData) {
		saveData(); 
		t.put(id, eData);
		
	}
		public static ArrayList<EnemyLogEntry> getEnemyLogData(String id) {
			return (ArrayList<EnemyLogEntry>) t.get(id);
		}
}

