
package project.items.UselessDemos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;

public class MedKitScreen extends Screen implements KeyListener{
	int health=50;
	public MedKitScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
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
		update();
		game.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
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

}