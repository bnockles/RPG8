package project.save;

public class SaveDemo {

	public static void main(String[] args) {
		SaveScreen save = new SaveScreen();

		try {
			Thread.sleep(7000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("charName is " + save.getStringData("charName"));
		System.out.println("charHealth is " + save.getIntData("charHealth"));
		System.out.println("testDouble is " + save.getDoubleData("testDouble"));
	}

}
