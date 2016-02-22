package project.towns;

import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.items.Item;
/**
 * 
 * @author Fei
 * This class is for running towns in order to test them.
 *
 */
public class Demo extends Game{
	ArrayList<Item> items;
	public static void main(String[] args) {
		new Demo();
	}

	public void reset() {
		//Screen townScreen = new TownScreen(this,3,3);
		//setScreen(townScreen);
		Screen shopScreen = new ShopScreen(this);
		setScreen(shopScreen);
		activeScreen.update();
		repaint();
	}
}
