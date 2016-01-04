package project.overworld;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
/**
 * This is a "Demo" of how to display images stored in the directory
 * You probably don't want to use this class as your actual overworld, 
 * since – otherthan implenting required methods, no insight was given into how
 * this class should function with the rest of the game as a whole
 * 
 * IMPORTANT: In this class you wil see a BufferedImage[] for the character
 * You would NOT want to do this in the actual overworld class. The character's sprite should
 * probably be stored in a Character class, which I have not done for you
 * 
 * Also, I apologize for the messiness in the paint method. It was lat at night and I started experimenting with some cool ways to animate
 * 
 * @author bnockles
 *
 */
public class DemoOverworld extends Screen implements KeyListener{

	/**You would not want these field in your actual Overworld class
	they should be fields in a Character class, but are here for demo purposes only
	*/
	BufferedImage[] spriteImages;
	int spriteX;
	int spriteY;
	int count;
	int waveCount;
	double waveHeight;
	boolean waveHeightIncreasing;
	boolean walking;
	int spriteWidth=60;
	int spriteHeight=107;
	public static final int SHORELINE = 200;
	public static final int MOVE_UNIT = 6;
	ArrayList<Integer> pressedKeys;//allow for multiple input
	
	public DemoOverworld(Game game) {
		super(game);
		//demo purposes only:
		count=0;
		waveCount=0;
		waveHeight=1;
		waveHeightIncreasing=false;
		pressedKeys = new ArrayList<Integer>();
		spriteImages=new BufferedImage[3];
		spriteX = 400;
		spriteY = 400;
		//try block must be used since files *might* not exist
		try {
			/**SPECIAL NOTE:
			 * Previously, I used "File" to import images,
			 *  but this did not work when exporting as a JAR:
			 *  spriteImages[0] = ImageIO.read(new File("images/sprites/standing.png"));
			 *  spriteImages[1] = ImageIO.read(new File("images/sprites/standing1.png"));
			 *  spriteImages[2] = ImageIO.read(new File("images/sprites/standing2.png"));
			 *  
			 *  See new implementation below, which works for Files and JARs
			 */
			URL url0 = getClass().getResource("/images/sprites/standing.png");
			URL url1 = getClass().getResource("/images/sprites/standing1.png");
			URL url2 = getClass().getResource("/images/sprites/standing2.png");
	
			spriteImages[0] = ImageIO.read(url0);
			spriteImages[1] = ImageIO.read(url1);
			spriteImages[2] = ImageIO.read(url2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		//make a "landscape"
		waveCount++;
		if(waveHeightIncreasing)waveHeight+=.05;
		else waveHeight-=.05;
		if(waveHeight>1.2)waveHeightIncreasing=false;
		if(waveHeight<=.5)waveHeightIncreasing=true;
		if(waveCount>62)waveCount=0;
		g2.setColor(Color.BLUE);
		g2.fillRect(0,0,width,height);
		g2.setColor(new Color(0,100,0));
		g2.fillRect(0,0,width-SHORELINE,height);
		g2.setColor(Color.GREEN);
		for(int r=0; r<height;r+=6){
			for(int c = 0; c<width-SHORELINE; c+=2){
				int c2 = c;
				if(waveCount>40)c2=c+1;
				if(c%6==0)g2.drawLine(c, r-4, c2,r);
				if(c%6==2)g2.drawLine(c, r-5, c2,r);
				else g2.drawLine(c, r-3, c2,r);
				
				if(r%18==0 && (c%6==0 || c%6==1|| c%6==4))c+=1;
				if(r%18==0 && (c%6==4))c+=4;
				if(r%18 == 12){
					g2.drawLine(c, r-3, c2,r);
					g2.drawLine(c+2, r-5, c2+2,r);
					c+=5;
				}
				if(r%18 == 6){
					g2.drawLine(c, r-4, c2,r);
					g2.drawLine(c-2, r-2, c2-2,r);
					c+=7;
				}
			}
		}
		g2.setColor(Color.WHITE);
		for(int r=0; r<height;r+=13){
			for(int c=width-SHORELINE; c<width;c++){
				int l1;
				int l2;
				int h = (int)(waveHeight*4);
				if(r%26==0){
					l1 = r+(int)(h*Math.sin((double)c/2+waveCount));
					l2 = r+(int)(h*Math.sin((double)(c+1)/2+waveCount));
					g2.drawLine(c, l1, c,l2);
				}else {
					l1 = r+(int)(h*Math.cos((double)c/2+waveCount));
					l2 = r+(int)(h*Math.cos((double)(c+1)/2+waveCount));
					g2.drawLine(c, l1, c,l2);
				}
			}
		}
		
		BufferedImage sprite = spriteImages[0];
		spriteWidth=60;
		if(walking && count < 2){
			sprite = spriteImages[1];
			spriteWidth=55;
		}
		else if (walking){
			sprite = spriteImages[2];
			spriteWidth=55;
		}
		if (count>3)count = 0;
		//shows the image exactly as it is:
//		g2.drawImage(sprite, spriteX, spriteY, null);
		//scales the image to a specified size
		g2.setColor(new Color(0,80,0));
		g2.fillOval(spriteX, spriteY+spriteHeight-12, spriteWidth, 20);
		UtilityMethods.scaleImage(g2, sprite,spriteX, spriteY, spriteWidth, spriteHeight );
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
	    	if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
	    }
		if(!pressedKeys.isEmpty()){
			walking=true;
			count++;
		}
	    if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)  && spriteY>0) spriteY-=MOVE_UNIT;
	    if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN) && spriteY<height-spriteHeight) spriteY+=MOVE_UNIT;
	    if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT) && spriteX < width-SHORELINE-spriteWidth) {
	    	spriteX+=MOVE_UNIT;
	    }
	    if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT) && spriteX>0) spriteX-=MOVE_UNIT;
	    
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
	    	pressedKeys.remove(pressedKeys.indexOf(keyCode));
	    }
	    if(pressedKeys.isEmpty())walking=false;
	}

}
