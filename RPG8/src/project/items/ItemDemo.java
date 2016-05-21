package project.items;

import project.items.ItemDemo;
import project.items.ItemScreen;
import project.mainmenudemo.DynamicMenu;
import project.directors.Game;
import project.directors.Screen;


public class ItemDemo extends Game {

	public static void main(String[] args) {
		new ItemDemo();
	}
	
//	public EnemyDemo() {
//		applySettings();//display the JFrame the way I want it
//		reset();//starts the game from the beginning
//		setVisible(true);
//	}
	
	public void reset() {
		Screen demoScreen = new ItemScreen(this);
		setScreen(demoScreen);
		repaint();	
		
	}
}
