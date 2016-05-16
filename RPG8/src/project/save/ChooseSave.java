package project.save;

/*
 * @author Wilson Wat
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChooseSave {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pick a save file: ");
		Save.chooseSave(in.nextInt());
		
		// Save.saveData("something", "A String!");
		// Save.saveData("test2", 3.14);
		
		ArrayList<Integer> testArr = new ArrayList<Integer>();
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		
		// BattleSave.saveData("testArr", testArr);
		// BattleSave.saveData();
		
		System.out.println("Testing load: " + Save.getString("something"));
		System.out.println("Testing load: " + Save.getDouble("test2"));
		
		ArrayList<Integer> resultArr = BattleSave.getIntArrayList("testArr");
		System.out.println(Arrays.toString(resultArr.toArray()));
	}
}
