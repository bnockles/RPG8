package project.battles.demo;

//more test
import java.awt.event.MouseListener;

import project.battles.demo.BattlesScreen;
import project.directors.Screen;
/**
 * 
 * @ Author: Chieh-Huang Chen
 * 
 */
public class BattlesDemoCancer extends project.directors.Game{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BattlesDemo();
	}
	//Testing 2
	public void BattlesDemoCancer() {
		applySettings();//display the JFrame the way I want it
		reset();//starts the game from the beginning
		setVisible(true);
	}
	public void reset() {
		Screen demoScreen = new BattlesScreenCancer(this);
		setScreen(demoScreen);
		addMouseListener((MouseListener) demoScreen);
		repaint();
	}
}
