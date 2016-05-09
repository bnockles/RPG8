package project.save;

/*
 * @author Wilson Wat
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SaveMain {
	
	// This would be moved to Game.java and replace the variable 'openGame'
	public static Save file1 = SaveUtility.getSaveFile(1);
	public static Save file2 = SaveUtility.getSaveFile(2);

	public static void main(String[] args) {
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
