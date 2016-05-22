package project.towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.directors.Visible;

public class ShopScreen extends Screen implements KeyListener{
	
	BufferedImage backGround = new BufferedImage(384, 288, BufferedImage.TYPE_INT_ARGB);;
	BufferedImage character;
	TownWanderer playable;
	WeaponStore store;
	int x;
	int y;
	int itemx = 92;
	int itemy = 60;
	ArrayList<Integer>itemN = new ArrayList<Integer>();
	Timer timer = new Timer();
	int status = 0;
	public ShopScreen(Game game) {
		super(game);
		for(int i = 0; i < 3; i++) itemN.add(i, 0);
		store = new WeaponStore(itemN, 10000);
		// TODO Auto-generated constructor stub
		try{
			backGround = ImageIO.read(getClass().getResource("/images/shop/pic.png"));
			character = ImageIO.read(getClass().getResource("/images/shop/Reddit-alien.png"));
			playable = new TownWanderer(450, game.getHeight()-115, "hero", "/images/sprites/standing.png", itemx);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		getKeyListener();
	}	

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}	
	
    
	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
//		for (int y = 0; y < game.getWindowWidth(); y++) {
//		    for (int x = 0; x < game.getWindowHeight(); x++){
		if(status == 0){
			g2.drawImage(backGround,0,0, null);
	    	g2.drawImage(backGround,0,288, null);
	    	g2.drawImage(backGround,0,576, null);
	    	g2.drawImage(backGround,384,0, null);
	    	g2.drawImage(backGround,384,288, null);
	    	g2.drawImage(backGround,384,576, null);
	    	g2.drawImage(backGround,768,0, null);
	    	g2.drawImage(backGround,768,288, null);
	    	g2.drawImage(backGround,768,576, null);
	    	g2.drawImage(character, 450,180,105,146, null);
	    	g2.drawOval(250 - 100, game.getHeight() -10 - 100, 100, 100);
	    	g2.setColor(Color.WHITE);
	    	g2.fillOval(250 - 100, game.getHeight() -10 - 100, 100, 100);
	    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),115,115, null);
		}
		if (status == 1){
			g2.drawString("Press B to buy and press S to sale.", 100, 50);
			g2.drawString("Player cash: " + store.getMoney(), 400, 50);
			g2.drawString("Item 1", 100, 100);
			g2.drawString("U owned: " + store.itemNu.get(0), 300, 100);
			g2.drawString("Item 2", 100, 200);
			g2.drawString("U owned: " + store.itemNu.get(1), 300, 200);
			g2.drawString("Item 3", 100, 300);
			g2.drawString("U owned: " + store.itemNu.get(2), 300, 300);
			g2.drawString("Price: 450", 200, 100);
			g2.drawString("Price: 350", 200, 200);
			g2.drawString("Price: 250", 200, 300);
			g2.drawRect(60, itemx, 5, 5);
			g2.fillRect(60, itemx, 5, 5);
		}
		if (status == 2){
			
		}
//		    }
//		}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			if(status == 0)
			playable .moveUp();
			if(status == 1)
				if(itemx > 92)
				itemx-= 100;
		}
		if(key == KeyEvent.VK_DOWN){
			if(status == 0)
			playable.moveDown();
			if(itemx < 292)
			itemx+= 100;
		}
		if(key == KeyEvent.VK_LEFT){
			if(status == 0)
			playable.moveLeft();
		}
		if(key == KeyEvent.VK_RIGHT){
			if(status == 0)
			playable.moveRight();
		}
		if(key == KeyEvent.VK_SPACE){
			if(status == 0){
				status++;
			}
		}
		if(key == KeyEvent.VK_ESCAPE){
			if(status == 1){
				status--;
			}
		}
		if(key == KeyEvent.VK_B){
			if(status == 1){
				store.moneyInteraction(itemx);
			}
		}
		if(key == KeyEvent.VK_S){
			if(status == 1){
				store.moneySellingInteraction(itemx);
			}
		}
		if(key == KeyEvent.VK_T){
			if(status == 0){
				if(Math.abs(150 - playable.getX()) <= 100 || Math.abs(game.getHeight() -10 - 100 - playable.getY()) <= 100){
					status = 2;
				}
			}
		}
			update();
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
