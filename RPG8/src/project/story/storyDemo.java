package project.story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import project.directors.Game;

/**
 * Samantha
 */

@SuppressWarnings("serial")
public class storyDemo extends Game{
	static String[] npc1Array = {"Hi!", "Are you in any way related to the cyborgs?", "Are the cyborgs actually bad people?", "I'll see you another time!"};
	public static NPC npc1 = new NPC(150, 150, "/images/heroes/IceDragon.jpg", npc1Array);
	public static Enemy enemy = new Enemy(200,200, "/images/heroes/Enemy.jpg");
	
	public static void main(String args[]){
		new storyDemo();
	}

	public storyDemo(){
		super();
		IntroCut.startGame();
	}
	
	public void reset(){
		storyScreen screen = new storyScreen(this);
		setScreen(screen);
		activeScreen.update();
		repaint();
	}
	
}
