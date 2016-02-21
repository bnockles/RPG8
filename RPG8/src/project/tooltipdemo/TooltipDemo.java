package project.tooltipdemo;

import project.directors.Screen;

public class TooltipDemo extends project.directors.Game{
		// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		new TooltipDemo();
	}
	
	public void reset() {
		Screen testScreen = new TestScreen(this);
		setScreen(testScreen);
		repaint();
	}
}