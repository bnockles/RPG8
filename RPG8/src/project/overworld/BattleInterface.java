package project.overworld;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.battles.demo.BattlesDemo;

public interface BattleInterface {
	final static int ZONE1 = 0;//starting screen
	final static int ZONE2 = 1;//map to the right of start
	final static int TOWN = 2;//the town
	
	public boolean isDead();
	public boolean killCharacter();
	public int getCharX();
	public int getCharY();
	public BufferedImage[] getFrontImage();
	public BufferedImage[] getBack();
	public BufferedImage[] getRight();
	public BufferedImage[] getLeft();
	
}
