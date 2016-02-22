package project.demo;

//hi lols
import project.demo.BattlesScreen;
import project.directors.Screen;

public class BattlesDemo extends project.directors.Game{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BattlesDemo();
	}
	//Testing 1
	public void BattlesDemo() {
		applySettings();//display the JFrame the way I want it
		reset();//starts the game from the beginning
		setVisible(true);
	}
	public void reset() {
		Screen demoScreen = new BattlesScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
