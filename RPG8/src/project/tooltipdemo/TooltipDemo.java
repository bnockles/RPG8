package project.tooltipdemo;

/**
 * Mark Mozgovoy
 */

import project.directors.Screen;

public class TooltipDemo extends project.directors.Game{
	
	public static void main(String[] args) {
		new TooltipDemo();
	}
	
	public void reset() {
		Screen testScreen = new DialogueDemo(this);
		setScreen(testScreen);
		repaint();
	}
}