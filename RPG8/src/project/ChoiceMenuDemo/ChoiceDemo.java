package project.ChoiceMenuDemo;

import project.directors.Screen;

/**
 * 
 * @author Maxwell Sulavko
 *
 */
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
