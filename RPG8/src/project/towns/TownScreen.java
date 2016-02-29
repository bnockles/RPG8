package project.towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;

/**
 * 
 * @author Fei and Jingwen
 *
 */
public class TownScreen extends Screen implements KeyListener{
	//Jingwen Code
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
	int status = 2;
	//Fei code
	BufferedImage[][] backgroundGrid;
	BufferedImage[][] obstacleGrid;

	//BufferedImage[][] foregroundGrid;
	int gridColumns;
	int gridRows;
	
	
	int currentRow;//index of the cell currently showing
	int currentColumn;//index of the cell currently showing
	
	int entranceRow;//the index of the cell where a character always enters from
	int entraceColumn;
	int entranceX;//exact location on the cell where the entrance is
	int entranceY;
	
	TownWanderer sprite;
	
	public TownScreen(Game game, int gridWidth, int gridHeight){
		super(game);
		this.gridColumns=gridWidth;
		this.gridRows=gridHeight;
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		obstacleGrid = new BufferedImage[gridHeight][gridWidth];
		
		currentRow = 1;// starting position when the character enters town
		currentColumn = 0;
		//example of starting screen for town but not actual
		
			try{
				backgroundGrid[currentRow][currentColumn] = ImageIO.read(getClass().getResource( "/images/maps/image1background.png" ) );
			}
			catch (IOException e) {
			}
			//JINGWEN CODE
			for(int i = 0; i < 3; i++) itemN.add(i, 0);
			store = new WeaponStore(itemN, 10000);
			// TODO Auto-generated constructor stub
			try{
				backGround = ImageIO.read(getClass().getResource("/images/shop/pic.png"));
				character = ImageIO.read(getClass().getResource("/images/shop/hey.jpg"));
				playable = new TownWanderer(450, game.getHeight()-115, "hero", "/images/shop/obama.jpg");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			getKeyListener();
		
		//qq
		
		
	}
	//Fei code

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}	
	
    //Jingwen COde
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
	    	g2.drawImage(character, 450,180,180,146, null);
	    	g2.drawOval(250 - 100, game.getHeight() -10 - 100, 100, 100);
	    	g2.setColor(Color.WHITE);
	    	g2.fillOval(250 - 100, game.getHeight() -10 - 100, 100, 100);
	    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),200,150, null);
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
			//Fei code
			g2.drawImage(backgroundGrid[currentRow][currentColumn], 0, 0, null);
			g2.drawImage(playable.getImage(),playable.getX(),playable.getY(),200,150,null);
			g2.drawOval(250 - 100, game.getHeight() -110, 100, 100);
			g2.drawString("USE T IN CIRCLE TO GO THROUGH CIRCLE, USE SPACE IN SHOP TO ACCESS SHOP ", 400, 500);
		}
//		    }
//		}
	}
	public int getEntranceX(){
		return entranceX;
	}
	//XXX
	
	
	public int getEntranceY(){
		return entranceY;
	}
	public int getcurrentRow(){
		return currentRow;
	}
	public int getCurrentColumn(){
		return currentColumn;
	}
	//JIngwen CODE
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			if(status == 0 || status == 2)
			playable .moveUp();
			if(status == 1)
				if(itemx > 92)
				itemx-= 100;
		}
		if(key == KeyEvent.VK_DOWN){
			if(status == 0 || status == 2)
			playable.moveDown();
			if(itemx < 292)
			itemx+= 100;
		}
		if(key == KeyEvent.VK_LEFT){
			if(status == 0 || status == 2)
			playable.moveLeft();
		}
		if(key == KeyEvent.VK_RIGHT){
			if(status == 0 || status == 2)
			playable.moveRight();
		}
		if(key == KeyEvent.VK_SPACE){
			if(status == 0){
				if(Math.abs(450 - playable.getX()) <= 100 && Math.abs(180 - playable.getY()) <= 100){
					status++;
				}
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
			if(status == 2){
				if(Math.abs(150 - playable.getX()) <= 100 && Math.abs(game.getHeight() -10 - 100 - playable.getY()) <= 100){
					System.out.print(Math.abs(game.getHeight() -110 - playable.getY()));
					status = 0;
				}
			}
			else if(status == 0){
				if(Math.abs(150 - playable.getX()) <= 100 && Math.abs(game.getHeight() -10 - 100 - playable.getY()) <= 100){
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

