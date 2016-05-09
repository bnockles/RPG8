package project.save;

/*
 * @author Wilson Wat
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SaveMain {
	
	// This would be moved to Game.java and replace the variable 'openGame'

	public static void main(String[] args) {
		Save file1 = new Save("battles");
		Save file2 = new Save("characters");
		
		file1.saveData("testInt", 1234);
		file1.saveData("testString", "Hello world.");
		
		System.out.println(file1.getInt("testInt"));
		System.out.println(file1.getString("testString"));

		file1.saveData();
		
		TestSave.testAdd();
		
		ArrayList<Integer> resultArr = file2.getIntArrayList("testInventory");
		System.out.println(Arrays.toString(resultArr.toArray()));
		
		file2.saveData();
	}

}
