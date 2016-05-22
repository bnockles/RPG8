package project.save;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSave {
	
	public static void test(boolean newFile) {
		if (newFile) {
			Save.saveData("PlayerLevel", 1);
			Save.saveData("StoryProgress", 0);
			
			ArrayList<String> items = new ArrayList<String>();
			items.add("Pistol");
			items.add("Something Else");
			items.add("I don't know");
			
			ItemSave.saveData("PlayerItems", items);
			Save.saveData();
			readFile();
		} else {
			// This is only here for the demo
			Save.saveData("PlayerLevel", 15);
			Save.saveData("StoryProgress", 10);
			
			ArrayList<String> items = new ArrayList<String>();
			items.add("BFG 9000");
			items.add("Something");
			items.add("Something again");
			
			ItemSave.saveData("PlayerItems", items);
			Save.saveData();
			readFile();
		}
	}
	
	public static void readFile() {
		System.out.println("Player level: " + Save.getInt("PlayerLevel"));
		System.out.println("Story progress: " + Save.getInt("StoryProgress"));
		ArrayList<String> items = ItemSave.getStringArrayList("PlayerItems");
		System.out.println("Player items: " + Arrays.toString(items.toArray()));
	}
}
