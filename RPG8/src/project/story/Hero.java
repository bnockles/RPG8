package project.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Samantha
 */

public class Hero {
	private final static String[] AyaRight = {"/images/heroes/right1.png", "/images/heroes/right2.png"};
	private final static String[] AyaLeft = {"/images/heroes/left1.png", "/images/heroes/left2.png"};	
	private final static String[] AyaForward = {"/images/heroes/forward1.png", "/images/heroes/forward2.png"};
	private final static String[] AyaBack = {"/images/heroes/back1.png", "/images/heroes/back2.png"};
	private final static String[] AyaStanding = {"/images/heroes/sForward.png", "/images/heroes/sLeft.png", 
		"/images/heroes/sRight.png", "/images/heroes/sBack.png"};
	BufferedImage sprite;
	private String name;
	private int x;
	private int y;
	private int width = 30;
	private int height = 46;
	public static int weapon = 10;
	public int strength = 100;
	
	public Hero(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
		animate(AyaStanding[0]);
	}	
	
	public void animate(String picLocation){
		URL url = getClass().getResource(picLocation);
		try {		
			sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			//what to draw, where to start (x and y coords), width of canvas relative to start, height of canvas relative to start,
			//where to start from original (x and y coords), width of original, height, null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public String getName(){
		return name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void setX(int i){
		x = i;
	}
	
	public void setY(int i){
		y = i;
	}
	
	public void moveUp() {
		y = y - 4;
		
	}

	public void moveDown() {
		y = y + 4;
		
	}

	public void moveRight() {
		x = x + 4;
		
		
	}

	public void moveLeft() {
		x = x - 4;
		
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void shoot() {
		if(weapon > 0) {
			weapon--;
			System.out.println("Bang!");
		}
		else{
			System.out.println("No Ammo");
		}
	}
	
	public void checkDimensions(){
		if(y <= 25){
			setY(32);
		}
		if(y >= storyScreen.height - 133){
			setY(storyScreen.height - 137);
		}
		if(x <= 3){
			setX(7);
		}
		if(x >= storyScreen.width - 33){
			setX(storyScreen.width - 37);
		}
	}
	
	public BufferedImage getImage(){
		return sprite;
	}
}
