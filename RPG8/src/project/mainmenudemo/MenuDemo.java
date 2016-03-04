package project.mainmenudemo;


import java.awt.Color;

import project.directors.Game;
import project.directors.Screen;
import project.mainmenudemo.DynamicMenu;;

public class MenuDemo extends project.directors.Game{
		// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		MenuDemo s = new MenuDemo();
	}
	
	public void reset() {
		Screen demoScreen = DynamicMenu.createMenu(0, this);
		setScreen(demoScreen);
		repaint();
	}
	

}