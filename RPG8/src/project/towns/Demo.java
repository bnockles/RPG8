package project.towns;

import java.util.ArrayList;
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
	TownWanderer playable;
	WeaponStore store;
	ArmorStore storeA;
	ConsumStore storeC;
	ArrayList<Integer>itemN = new ArrayList<Integer>();
	public static void main(String[] args) {
		new Demo();
	}
	public void reset() {
		//Screen townScreen = new TownScreen(this,3,3);
		//setScreen(townScreen);;
		playable = new TownWanderer(450, this.getHeight()-115, "hero", "/images/shop/pepe2.png", 10000);
		store = new WeaponStore(itemN, playable.getMoney());
		storeA = new ArmorStore(itemN, playable.getMoney());
		storeC = new ConsumStore(itemN, playable.getMoney());
		ArrayList<Integer> items = new ArrayList<Integer>();
		Screen shopScreen = new TownScreen(this, 3, 3, 0, store, storeA, storeC, playable);
		setScreen(shopScreen);
		activeScreen.update();
		repaint();
	}
	
	
}
