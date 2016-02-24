package project.towns;

import java.util.ArrayList;
import java.util.Arrays;

import project.directors.Game;
import project.directors.Screen;
/**
 * 
 * @author Fei
 * This class is for running towns in order to test them.
 *
 */
@SuppressWarnings("serial")
public class Demo extends Game{

	public static void main(String[] args) {
		new Demo();
	}
	public void reset() {
		//Screen townScreen = new TownScreen(this,3,3);
		//setScreen(townScreen);;
		ArrayList<String> items = new ArrayList<String>();
		items.add("item 1");
		items.add("item 2");
		items.add("item 3");
		WeaponStore Weapon = new WeaponStore(this, items, 9000);
		Screen shopScreen = new ShopScreen(this);
		setScreen(shopScreen);
		activeScreen.update();
		repaint();
	}
	
	public void set(){
		Screen shopScreen = new ShopScreen(this);
		setScreen(shopScreen);
		activeScreen.update();
		repaint();
	}
	
}
