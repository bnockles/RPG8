package project.save;

import project.directors.Game;
import project.directors.StartScreen;

public class SaveMain extends Game {
	public static void main(String[] args) {
		new Game();
	}
	
	public void reset() {
		SaveScreen saveScreen = new SaveScreen(this);
		setScreen(saveScreen);
		activeScreen.update();
		repaint();
	}
}
