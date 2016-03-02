package project.save;

public class SaveMain {

	public static void main(String[] args) {
		Save file1 = new Save(0);
		file1.saveData("something", 1234);
		file1.t.get("something");

	}

}
