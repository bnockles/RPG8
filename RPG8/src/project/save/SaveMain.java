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
		BattleSave file1 = new BattleSave("battles");
		CharacterSave file2 = new CharacterSave("characters");
		
		file1.saveData("testInt", 1234);
		file1.saveData("testString", "Hello world.");
		
		System.out.println(file1.getInt("testInt"));
		System.out.println(file1.getString("testString"));
<<<<<<< HEAD
=======
		
		file1.saveData();
>>>>>>> 27b4a1160dc90b015bea6ed1693ce06adc86041a
		
		ArrayList<Integer> testArr = new ArrayList<Integer>();
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		
		file2.saveData("testInventory", testArr);
<<<<<<< HEAD
		
		Save[] saves = {file1, file2};
		for (Save file: saves) {
			file.saveData();
		}
=======
		file2.saveData();
>>>>>>> 27b4a1160dc90b015bea6ed1693ce06adc86041a
		
		TestSave.testRead();
	}

}
