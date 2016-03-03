package project.save;

public class SaveMain {

	public static void main(String[] args) {
		Save file1 = SaveUtility.getSaveFile(2);
		
		file1.saveData("testInt", 1234);
		file1.saveData("testString", "Hello world.");
		
		System.out.println(file1.getInt("testInt"));
		System.out.println(file1.getString("testString"));
		file1.saveData();
	}

}
