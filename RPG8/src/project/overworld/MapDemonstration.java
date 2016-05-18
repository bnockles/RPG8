package project.overworld;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesDemo;
import project.battles.demo.BattlesScreen;
import project.directors.Game;
import project.directors.Screen;



public class MapDemonstration extends Game {
	static BufferedImage[] playerImg;
	public static void main(String[] args){
		new MapDemonstration();
		
	}
	public MapDemonstration(){
		super();
	}
	public void reset() {
		MapDemoScreen MapDemoScreen = new MapDemoScreen(this);
		BattlesScreen d = new BattlesScreen(this);
		playerImg = d.getFrontImage();
		setScreen(MapDemoScreen);
	}
	public void changeScreens(){
		BattlesScreen demoScreen = new BattlesScreen(this);
		setScreen(demoScreen);
		addMouseListener((MouseListener) demoScreen);
		
		repaint();
	}
	public void changeScreensM(){
		MapDemoScreen demoScreen = new MapDemoScreen(this);
		setScreen(demoScreen);
		repaint();
		
	}
	public BufferedImage[] getPI(){
		return playerImg;
	}
	
	
}
