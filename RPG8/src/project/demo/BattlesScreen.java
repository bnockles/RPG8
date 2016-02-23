package project.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class BattlesScreen extends Screen implements KeyListener,ActionListener{
	SampleMCharacter char1;
	SampleKEnemy enemy1;
	SampleGEnemy enemy2;
	public static ArrayList<SampleProjectiles> player = new ArrayList<SampleProjectiles>();
	public static ArrayList<SampleProjectiles> enemy = new ArrayList<SampleProjectiles>();
	Timer timer = new Timer(5,this);
	
	public BattlesScreen(Game game){
		super(game);
		
		char1 =  new SampleMCharacter("/images/character/mc.jpg",100,100,100,100);
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
			timer.start();
			g2.drawImage(char1.getImage(),char1.getPositionX(),char1.getPositionY(),null);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<player.size();i++){
			player.get(i).fly();
		}
		for(int i=0;i<enemy.size();i++){
			enemy.get(i).fly();
		}
		update();
	}
}
