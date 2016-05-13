package project.story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.overworld.DemoOverworld;

/**
 * Samantha
 */

@SuppressWarnings("unused")
public class storyScreen extends Screen implements KeyListener{
	public static int num;
	private static final int MOVE_UNIT = 0;
	public ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	BufferedImage landscape;
	public static Hero Swarm = new Hero("Aya", 105, 105);
	public static int height;
	public static int width;

	public storyScreen(Game game) {
		super(game);
		setHeight();
		setWidth();
	}

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			//only add keys if they aren't already in the ArrayList
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}

		//other keys don't get combined with other keys, so they don't need to be added

		if(keyCode == KeyEvent.VK_UP){

			Swarm.moveUp();
		}
		else if(keyCode == KeyEvent.VK_DOWN){			

			Swarm.moveDown();
		}
		else if(keyCode == KeyEvent.VK_RIGHT){

			Swarm.moveRight();
		}
		else if(keyCode == KeyEvent.VK_LEFT){

			Swarm.moveLeft();
		}
		else if(keyCode == KeyEvent.VK_S) {
			Swarm.shoot();
		}
		else if(keyCode == KeyEvent.VK_Y) {
			num = 1;
		}
		else if(keyCode == KeyEvent.VK_N) {
			num = 2;
		}

		Swarm.checkDimensions();
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

		}
		else if(keyCode == KeyEvent.VK_DOWN){			

		}
		else if(keyCode == KeyEvent.VK_RIGHT){

		}
		else if(keyCode == KeyEvent.VK_LEFT){

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
		g2.fillRect(0, 0, width, height);
	}

	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() + MOVE_UNIT); 
	}
	
	public void setHeight(){
		height = super.height;
	}
	
	public void setWidth(){
		width = super.width;
	}

//	public void paint(Graphics g){
//		//		//sets image to current windowWidth/height
//		Graphics2D g2 = (Graphics2D)g;
//		g2.drawImage(landscape, 0, 0, null);
//		g2.setColor(Color.black);
//		g2.fillRect(0, super.height - 91, super.width, 91);
//	}
}
