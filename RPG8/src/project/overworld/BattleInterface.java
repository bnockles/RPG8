package project.overworld;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.battles.demo.BattlesDemo;

public interface BattleInterface {
	final static int ZONE1 = 0;//starting screen
	final static int ZONE2 = 1;//map to the right of start
	final static int TOWN = 2;//the town
	
	public boolean isDead(Character c);
	public boolean killCharacter(Character c);
	public int getCharX(Character c);
	public int getCharRegion(Character c);
	public int getCharY(Character c);
	ArrayList<Character> getCharacter(ArrayList<Character> c);
	BattleInterface getBattleInterface(BattlesDemo b);
}
