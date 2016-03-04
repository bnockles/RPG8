package project.save;

import java.util.ArrayList;
import java.util.Arrays;

public class SaveMain {

	public static void main(String[] args) {
		Save file1 = SaveUtility.getSaveFile(1);
		Save file2 = SaveUtility.getSaveFile(2);
		
		file1.saveData("testInt", 1234);
		file1.saveData("testString", "Hello world.");
		
		System.out.println(file1.getInt("testInt"));
		System.out.println(file1.getString("testString"));

		file1.saveData();
		
		ArrayList<Integer> testArr = new ArrayList<Integer>();
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		
		file2.saveData("testInventory", testArr);
		
		ArrayList<Integer> resultArr = file2.getIntArrayList("testInventory");
		System.out.println(Arrays.toString(resultArr.toArray()));
		
		file2.saveData();
	}

}
