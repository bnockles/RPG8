package project.controls;

/**
 * Author Jacky
 */

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;

public class DemoControlsNew extends project.directors.Screen implements KeyListener,MenuInteraction,BattlesInteraction{
	
	double walking = 15;
	String  s = "Press 1 to select Menu. Press 2 to select Battles.";
	Boolean selection = false;
	Boolean game = false;
	Boolean menu = false;
	
	

	public DemoControlsNew(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
	}
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
	}
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
	}
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub	
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE){
			selection = false; 
			game = false;
			menu = false; 
			s = "Press 1 to select Menu. Press 2 to select Battles";
		}
		if(keyCode == KeyEvent.VK_1){
				selection = true; 
				menu = true;
				s="You are now in menu";
				
		}
		if(keyCode == KeyEvent.VK_2){
			selection = true; 
			game = true;
			s="You are now in Battles";
		}
		
	
		
		
	}
	



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
}
