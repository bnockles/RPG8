package ChoiceMenuDemo;

import project.directors.Screen;

public class ChoiceDemo extends project.directors.Game{

	public static void main(String[] args) {
		new ChoiceDemo();
	}

	public void reset() {
		Screen testGrid = new GridToSee(this);
		setScreen(testGrid);
		repaint();
	}
}
