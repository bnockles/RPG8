package project.towns;

import project.directors.Game;
import project.directors.Screen;
import project.directors.StartScreen;
/**
 * 
 * @author Fei
 * This class is for running towns in order to test them.
 *
 */
public class Demo extends Game {

	
	
	
	public static void main(String[] args) {
		new Demo();
	}

	public void reset() {
		Screen townScreen = new TownScreen(this,3,3);
		setScreen(townScreen);
		activeScreen.update();
		repaint();
	}
	
}
