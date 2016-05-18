/**
 * 
 */
package project.demo;

import project.demo.ItemScreen;
import project.directors.Screen;



/**
 * 
 * @author Mr. Nockles
 * 
 * I have written this class to demonstrate to the class how to get started 
 * with their demo. I have intentionally made this demo BARE BONES
 * so that you are left with a lot of work to do!
 *
 */
public class ItemDemo extends project.directors.Game{

	
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
