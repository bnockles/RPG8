package project.overworld;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import project.battles.demo.BattlesDemo;
import project.battles.demo.BattlesScreen;
import project.directors.Game;
import project.directors.Screen;



public class MapDemonstration extends Game {
	static BufferedImage[] playerImg;
	static boolean gameState;
	static MapDemoScreen mapDemo;
	static BattlesScreen batt;
	public static void main(String[] args){
		new MapDemonstration();	
	}
	public MapDemonstration(){
		super();
	}
	public void reset() {
		mapDemo = new MapDemoScreen(this);
		batt = new BattlesScreen(this);
		playerImg = batt.getFrontImage();
		setScreen(mapDemo);
	}
	public void changeScreens(){
		setScreen(batt);
		addMouseListener((MouseListener) batt);
		repaint();
		test();
	}
	public void test(){
		
	}
	public void changeScreensM(){
		setScreen(mapDemo);
		repaint();
		
	}
	public BufferedImage[] getPI(){
		return playerImg;
	}
	
	
}
