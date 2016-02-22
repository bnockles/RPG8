package project.towns;

import java.awt.Graphics2D;
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
	BufferedImage playable;
	int x;
	int y;
	TownWanderer sprite;
	ArrayList<Integer>pressedKeys;
	Timer timer = new Timer();
	
	public ShopScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		try{
			backGround = ImageIO.read(new URL("http://i1067.photobucket.com/albums/u429/colinharvie/RPGMaker%20MV%20Tiles/MV_WoodAutoTiles_Ezra_color1_zpso4kqtxet.png"));
			URL url = getClass().getResource("/images/sprites/standing.png"); 
			playable = ImageIO.read(url);
			character = ImageIO.read(new URL("http://vignette2.wikia.nocookie.net/reddits-world/images/f/fc/Reddit-alien.png/revision/latest?cb=20140914033417"));
			sprite = new TownWanderer(450, game.getHeight()-115);
		}
		catch (IOException e) {
		}
	}	

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}	
	
    
	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
//		for (int y = 0; y < game.getWindowWidth(); y++) {
//		    for (int x = 0; x < game.getWindowHeight(); x++){
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
		    	g2.drawImage(playable, sprite.getX(),sprite.getY(),115,115, null);
//		    }
//		}
	}
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();

		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
		//only add keys if they aren't already in the ArrayList
		if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}

		//other keys don't get combined with other keys, so they don't need to be added
		if(keyCode == KeyEvent.VK_SPACE){
			
		}

		//if pressing keys should change the graphics, call update()
		update();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			    respondToKeyInput();
			  }
			}, (long)500, (long)500);
	}

		@Override
	public synchronized void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		//check if an arrow key is released and removes it from pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
		pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}

		//if releasing keys should change the graphics, call update()
		update();
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) sprite.setY(sprite.getY() - 2); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) sprite.setY(sprite.getY() + 2); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) sprite.setX(sprite.getX() - 2); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) sprite.setX(sprite.getX() + 2); 
		}


}
