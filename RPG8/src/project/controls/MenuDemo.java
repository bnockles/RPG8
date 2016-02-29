package project.controls;

/** author Jacky */

import project.directors.Screen;

public class MenuDemo extends project.directors.Game{
		// TODO Auto-generated constructor stub

	public static void main(String[] args) {
		MenuDemo s = new MenuDemo();
	}

	public void reset() {
		Screen demoScreen = new MenuControls(this);
		setScreen(demoScreen);
		repaint();
	}
}