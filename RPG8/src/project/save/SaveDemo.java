package project.save;

import project.directors.Game;
import project.directors.Screen;
import project.directors.StartScreen;

public class SaveDemo extends Game {

	public static void main(String[] args) {
		new SaveDemo();
	}
	
	public void reset() {
		Screen saveScreen = new SaveScreen(this);
		setScreen(saveScreen);
		repaint();
	}
}
