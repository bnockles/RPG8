package project.items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;

public class ItemScreen extends Screen implements KeyListener{
	int health=50;
	int ammo=100;
	
	public ItemScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.green);
		g2.fillRect(30, 90, health, 20);
		g2.setColor(Color.black);
		g2.drawString("Player 1", 30, 70);
		g2.drawRect(30,90,100,20);
		g2.drawString("Press E to heal", 30, 130);
		g2.drawString("Press Q to take damage", 30, 145);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E){
			if(health<100){
				health+=20;
			}
			if(health>100){
				health=100;
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_Q){
			if(health>0){
				health-=30;
			}
			if(health<0){
				health=0;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_R){ 
			ammo +=10;
			if(ammo>100)ammo=100;
		}
		update();
		game.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
