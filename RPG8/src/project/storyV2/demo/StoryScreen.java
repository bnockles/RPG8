package project.storyV2.demo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.overworld.DemoOverworld;
import project.storyV2.Cutscenes;
import project.storyV2.IntroCut;

public class StoryScreen extends Screen implements KeyListener {
	
	final static ArrayList<String> AyaForward = new ArrayList<String>();
	private static String forward = "/images/heroes/sForward.png";
	private static String forward1 = "/images/heroes/forward1.png";
	private static String forward2 = "/images/heroes/forward2.png";
	final static ArrayList<String> AyaLeft = new ArrayList<String>();
	private static String left = "/images/heroes/sLeft.png";
	private static String left1 = "/images/heroes/left1.png";
	private static String left2 = "/images/heroes/left2.png";
	final static ArrayList<String> AyaRight = new ArrayList<String>();
	private static String right = "/images/heroes/sRight.png";
	private static String right1 = "/images/heroes/right1.png";
	private static String right2 = "/images/heroes/right2.png";
	final static ArrayList<String> AyaBack = new ArrayList<String>();
	private static String back = "/images/heroes/sBack.png";
	private static String back1 = "/images/heroes/back1.png";
	private static String back2 = "/images/heroes/back2.png";
	final static ArrayList<String> AyaStanding = new ArrayList<String>();
	private static final int MOVE_UNIT = 5;
	public static Hero Swarm;
	public ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public Cutscenes cutscene;
	public StoryScreen(Game game) {
		super(game);
		AyaForward.add(forward1);
		AyaForward.add(forward2);
		AyaLeft.add(left1);
		AyaLeft.add(left2);
		AyaRight.add(right1);
		AyaRight.add(right2);
		AyaBack.add(back1);
		AyaBack.add(back2);
		AyaStanding.add(forward);
		AyaStanding.add(left);
		AyaStanding.add(right);
		AyaStanding.add(back);
		Swarm = new Hero("Aya Drevis", 105, 105);
		Swarm.animate(AyaStanding.get(0));
		cutscene =  new IntroCut();
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(cutscene.getBufferedImage(), 0, 0, null);
		g2.drawImage(Swarm.getImage(), Swarm.getX(), Swarm.getY(), null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
			//check if an arrow key is pressed and add it to pressedKeys if it is
			if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
				//only add keys if they aren't already in the ArrayList
				if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
			}

			//other keys don't get combined with other keys, so they don't need to be added
			if(keyCode == KeyEvent.VK_SPACE){
				//stuff that happens when the spacebar is pressed
//				Screen mainMenu = new DemoOverworld(game);
//				game.setScreen(mainMenu);
			}

			if(keyCode == KeyEvent.VK_UP){
				Swarm.animate(AyaStanding.get(3));
				Swarm.moveUp();
			}
			
		
			else if(keyCode == KeyEvent.VK_DOWN){			
				Swarm.animate(AyaStanding.get(0));
				Swarm.moveDown();
			}
			else if(keyCode == KeyEvent.VK_RIGHT){
				Swarm.animate(AyaStanding.get(2));
				Swarm.moveRight();
			}
			else if(keyCode == KeyEvent.VK_LEFT){
				Swarm.animate(AyaStanding.get(1));
				Swarm.moveLeft();
			}
			else if(keyCode == KeyEvent.VK_S) {
				//Swarm.shoot();
			}
			else if(keyCode == KeyEvent.VK_R) {
				//Swarm.radio();
			}
			
			Swarm.checkDimensions();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
			//check if an arrow key is released and removes it from pressedKeys if it is
			if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
				pressedKeys.remove(pressedKeys.indexOf(keyCode));
			}

			if(keyCode == KeyEvent.VK_UP){
				Swarm.animate(AyaStanding.get(3));
			}
			else if(keyCode == KeyEvent.VK_DOWN){			
				Swarm.animate(AyaStanding.get(0));
			}
			else if(keyCode == KeyEvent.VK_RIGHT){
				Swarm.animate(AyaStanding.get(2));
			}
			else if(keyCode == KeyEvent.VK_LEFT){
				Swarm.animate(AyaStanding.get(1));
			}

			respondToKeyInput();
	}
	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() + MOVE_UNIT); 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
