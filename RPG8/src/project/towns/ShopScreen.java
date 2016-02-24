package project.towns;

import java.awt.Graphics2D;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
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
	
	BufferedImage backGround;
	BufferedImage character;
	TownWanderer playable;
	int x;
	int y;
	ArrayList<Integer>pressedKeys;
	Timer timer = new Timer();
	int status = 0;
	public ShopScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		try{
			backGround = ImageIO.read(new URL("http://i1067.photobucket.com/albums/u429/colinharvie/RPGMaker%20MV%20Tiles/MV_WoodAutoTiles_Ezra_color1_zpso4kqtxet.png"));
			character = ImageIO.read(new URL("http://vignette2.wikia.nocookie.net/reddits-world/images/f/fc/Reddit-alien.png/revision/latest?cb=20140914033417"));
			playable = new TownWanderer(450, game.getHeight()-115, "hero", "/images/sprites/standing.png");
		}
		catch (IOException e) {
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
	    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),115,115, null);
		}
		if (status == 1){
			g2.drawString(WeaponStore.items.get(0), 100, 100);
			g2.drawString(WeaponStore.items.get(1), 100, 200);
			g2.drawString(WeaponStore.items.get(2), 100, 300);
		}
//		    }
//		}
	}
	
	public void paintInv(Graphics2D g2){
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			playable .moveUp();
		}
		if(key == KeyEvent.VK_DOWN){
			playable.moveDown();
		}
		if(key == KeyEvent.VK_LEFT){
			playable.moveLeft();
		}
		if(key == KeyEvent.VK_RIGHT){
			playable.moveRight();
		}
		if(key == KeyEvent.VK_SPACE){
			if(status == 0){
				status++;
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
