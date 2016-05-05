package project.controls;

/** author Vincent & Jacky */

import java.awt.event.MouseListener;

import project.directors.Screen;

public class ControlsDemo extends project.directors.Game{
		// TODO Auto-generated constructor stub

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		ControlsDemo demo = new ControlsDemo();
	}

	public void reset() {
		Screen demoScreen = new DemoControls2pointooooooo(this);
		setScreen(demoScreen);
		addMouseListener((MouseListener) demoScreen);
		repaint();
	}
}