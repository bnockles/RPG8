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
import project.items.ItemResources;

public class ShopScreen extends Screen implements KeyListener{
	
	BufferedImage backGround = new BufferedImage(384, 288, BufferedImage.TYPE_INT_ARGB);;
	BufferedImage character;
	TownWanderer playable;
	int x;
	int y;
	int boxX = 50;
	int boxY =80;
	int itemx = 92;
	int itemy = 60;
	WeaponStore store;
	ArmorStore storeA;
	ConsumStore storeC;
	BufferedImage t;
	ArrayList<Integer>itemN = new ArrayList<Integer>();
	Timer timer = new Timer();
	int status;
	BufferedImage itemI;
	public ShopScreen(Game game, int status, WeaponStore a, ArmorStore b, ConsumStore c, TownWanderer s) {
		super(game);
		getKeyListener();
		this.status = status;
		store = a;
		storeA = b;
		storeC = c;
		playable = s;
		t = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
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
		if(status == 2){
			paintInShop(TownScreen.store, g2);
			System.out.print("ayy lmao");
		}
		if (status == 3){
			paintInShopA(TownScreen.storeA, g2);
		}
		if (status == 4){
			paintInShopC(TownScreen.storeC, g2);
		}
//		    }
//		}
	}
	private void paintInShopC(ConsumStore s, Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(boxX, boxY, 900, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		int y=100;
		int count = 0;
		for(ShopItems x: s.itemListC){
			g2.drawString("U owned: " + s.itemNC.get(count), 400, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 300, y);
			g2.drawString(x.getDescription(), 500, y);
			try {
				itemI = ImageIO.read(getClass().getResource("/images/items/" + x.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2.drawImage(itemI,800,y, null);
			y+=100;
			count++;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}

	private void paintInShopA(ArmorStore s, Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(boxX, boxY, 900, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		
		int y=100;
		int count = 0;
		for(ShopItems x: s.itemListA){
			g2.drawString("U owned: " + s.itemNA.get(count), 400, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 300, y);
			g2.drawString(x.getDescription(), 500, y);
			try {
				itemI = ImageIO.read(getClass().getResource("/images/items/" + x.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2.drawImage(itemI,800,y, null);
			y+=100;
			count++;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}
	public void paintInShop(WeaponStore s, Graphics2D g2){
		//g2.drawRect(boxX, boxY, 900, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		
		int y=100;
		int y2 = 100; 
		int count = 0;
		for(ShopItems x: s.itemListW){
			g2.drawString("U owned: " + s.itemNuW.get(count), 400, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 300, y);
			g2.drawString(x.getDescription(), 500, y);
			URL url = getClass().getResource(x.getItemImage());
			try {
				itemI = ImageIO.read(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2.drawImage(itemI, 650, y2, 200, 100, null);	
			y2+=100;
			y+=100;
			count++;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			if(itemx > 92){
				itemx-= 100;
				boxY-= 100;
			}
		}
		if(key == KeyEvent.VK_DOWN){
			if(itemx < 92 + (TownScreen.getStore().getItemListW().size()-1)*100){
				itemx+= 100;
				boxY+= 100;
			}
		}
		if(key == KeyEvent.VK_ESCAPE){
			Screen Screen = new TownScreen(game, 3, 3, status, store, storeA, storeC, playable);
			game.setScreen(Screen);
		}
		if(key == KeyEvent.VK_RIGHT){
			if(status < 4){
				status++;
			}
		}
		if(key == KeyEvent.VK_LEFT){
			if(status > 2){
				status--;
			}
		}
		if(key == KeyEvent.VK_B){
			if(status == 2)
			store.moneyInteraction(itemx);
			if(status == 3)
			storeA.moneyInteraction(itemx);
			if(status == 4)
			storeC.moneyInteraction(itemx);
		}
		if(key == KeyEvent.VK_S){
				if(status == 2)
				store.moneySellingInteraction(itemx);
				if(status == 3)
				storeA.moneySellingInteraction(itemx);
				if(status == 4)
				storeC.moneySellingInteraction(itemx);
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
