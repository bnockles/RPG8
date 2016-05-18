package project.mainmenudemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.menus.Selectable;

public class MainMenuSelectables implements Selectable{

	public String name;
	//Since I do not know how the game will save
	//or load, or what options will be available to the player, or what "help"
	//the player will need, this will be left with the name only
	
	public MainMenuSelectables(String name){
		this.name = name;
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
