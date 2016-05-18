package project.overworld;

import java.awt.event.MouseListener;

import project.battles.demo.BattlesDemo;
import project.battles.demo.BattlesScreen;
import project.directors.Game;
import project.directors.Screen;



public class MapDemonstration extends Game {

	public static void main(String[] args){
		new MapDemonstration();
	}
	public MapDemonstration(){
		super();
	}
	public void reset() {
		MapDemoScreen MapDemoScreen = new MapDemoScreen(this);
		setScreen(MapDemoScreen);
	}
	public void changeScreens(){
		Screen demoScreen = new BattlesScreen(this);
		setScreen(demoScreen);
		addMouseListener((MouseListener) demoScreen);
		repaint();
	}
	
	
}
