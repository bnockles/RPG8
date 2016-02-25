package project.story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.overworld.DemoOverworld;

@SuppressWarnings("unused")
public class storyScreen extends Screen implements KeyListener{

	private static final int MOVE_UNIT = 0;
	public ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	BufferedImage landscape;

	public storyScreen(Game game) {
		super(game);
	}

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			//only add keys if they aren't already in the ArrayList
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}

		//other keys don't get combined with other keys, so they don't need to be added
		if(keyCode == KeyEvent.VK_SPACE){
			//stuff that happens when the spacebar is pressed
			Screen mainMenu = new DemoOverworld(game);
			game.setScreen(mainMenu);
		}

		if(keyCode == KeyEvent.VK_UP){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(3));
			storyDemo.Aya.moveUp();
		}
		else if(keyCode == KeyEvent.VK_DOWN){			
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(0));
			storyDemo.Aya.moveDown();
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(2));
			storyDemo.Aya.moveRight();
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(1));
			storyDemo.Aya.moveLeft();
		}
		else if(keyCode == KeyEvent.VK_S) {
			storyDemo.Aya.shoot();
		}
		else if(keyCode == KeyEvent.VK_R) {
			storyDemo.Aya.radio();
		}
		
		//if pressing keys should change the graphics, call update()
		update();	
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		//check if an arrow key is released and removes it from pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		
		if(keyCode == KeyEvent.VK_UP){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(3));
		}
		else if(keyCode == KeyEvent.VK_DOWN){			
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(0));
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(2));
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			storyDemo.Aya.animate(storyDemo.AyaStanding.get(1));
		}

		//if releasing keys should change the graphics, call update()
		update();

		respondToKeyInput();
	}

	public void keyTyped(KeyEvent e){

	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}
	
	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.black);
	}

	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) storyDemo.Aya.setY(storyDemo.Aya.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) storyDemo.Aya.setY(storyDemo.Aya.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) storyDemo.Aya.setX(storyDemo.Aya.getX() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) storyDemo.Aya.setX(storyDemo.Aya.getX() + MOVE_UNIT); 
	}

}
