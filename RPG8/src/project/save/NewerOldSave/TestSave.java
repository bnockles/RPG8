package project.save;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSave {
	
	public static void testRead() {
		CharacterSave file = new CharacterSave("characters");

		ArrayList<Integer> resultArr = file.getIntArrayList("testInventory");
		System.out.println(Arrays.toString(resultArr.toArray()));
	}
}
