package project.items.UselessDemos;

import project.directors.Game;
import project.directors.Screen;

public class AmmoDemo extends Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AmmoDemo();
	}

	public void reset() {
		Screen demoScreen = new AmmoScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
