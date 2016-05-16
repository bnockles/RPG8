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

	public static void main(String[] args) {
		new Demo();
	}
	public void reset() {
		//Screen townScreen = new TownScreen(this,3,3);
		//setScreen(townScreen);;
		ArrayList<Integer> items = new ArrayList<Integer>();
		Screen shopScreen = new TownScreen(this, 3, 3);
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
