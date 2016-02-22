package project.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.items.Weapon;

public class BattlesScreen extends Screen implements KeyListener{
	SampleMCharacter char1;
	SampleKEnemy enemy1;
	SampleGEnemy enemy2;
	public static ArrayList<SampleProjectiles> player = new ArrayList<SampleProjectiles>();
	public static ArrayList<SampleProjectiles> enemy = new ArrayList<SampleProjectiles>();

	public BattlesScreen(Game game){
		super(game);
		char1 =  new SampleMCharacter();
		//enemy1 = new SampleKEnemy(new int[6],new Weapon(),true);
		//enemy2 = new SampleGEnemy(new int[6],new Weapon(),true);
		update();
	}
	
	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("Battles Team's Demo", 100, 100);
			g2.setColor(Color.green);
		}
		catch(Exception e){
			
		}
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			
		}
		if(key == KeyEvent.VK_DOWN){
			
		}
		if(key == KeyEvent.VK_LEFT){
			
		}
		if(key == KeyEvent.VK_RIGHT){
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
