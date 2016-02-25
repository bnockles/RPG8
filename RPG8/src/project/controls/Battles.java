package project.controls;

/** author Vincent */

import project.directors.Screen;

public class Battles extends project.directors.Game{
		// TODO Auto-generated constructor stub

	public static void main(String[] args) {
		Battles demo = new Battles();
	}

	public void reset() {
		Screen demoScreen = new BattlesControls(this);
		setScreen(demoScreen);
		repaint();
	}
}