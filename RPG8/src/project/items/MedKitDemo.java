package project.items;

import project.items.MedKitScreen;
import project.directors.Screen;

public class MedKitDemo extends project.directors.Game{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MedKitDemo();
	}
	public void reset() {
		Screen demoScreen = new MedKitScreen(this);
		setScreen(demoScreen);
		repaint();
	}

}
