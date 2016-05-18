package project.storyV2.demo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Samantha
 */

public class Hero {

	BufferedImage sprite;
	public String name;
	public int x;
	public int y;
	int width = 30;
	int height = 46;
	boolean zero = true;
	public static int weapon = 10;
	public int strength = 100;
	
	private final static ArrayList<String> AyaForward = new ArrayList<String>();
	private static String forward = "/images/heroes/sForward.png";
	private static String forward1 = "/images/heroes/forward1.png";
	private static String forward2 = "/images/heroes/forward2.png";
	private final static ArrayList<String> AyaLeft = new ArrayList<String>();
	private static String left = "/images/heroes/sLeft.png";
	private static String left1 = "/images/heroes/left1.png";
	private static String left2 = "/images/heroes/left2.png";
	private final static ArrayList<String> AyaRight = new ArrayList<String>();
	private static String right = "/images/heroes/sRight.png";
	private static String right1 = "/images/heroes/right1.png";
	private static String right2 = "/images/heroes/right2.png";
	private final static ArrayList<String> AyaBack = new ArrayList<String>();
	private static String back = "/images/heroes/sBack.png";
	private static String back1 = "/images/heroes/back1.png";
	private static String back2 = "/images/heroes/back2.png";
	public final ArrayList<String> AyaStanding = new ArrayList<String>();
	
	public Hero(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
		AyaForward.add(forward1);
		AyaForward.add(forward2);
		AyaLeft.add(left1);
		AyaLeft.add(left2);
		AyaRight.add(right1);
		AyaRight.add(right2);
		AyaBack.add(back1);
		AyaBack.add(back2);
		AyaStanding.add(forward);
		AyaStanding.add(left);
		AyaStanding.add(right);
		AyaStanding.add(back);
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
		y = y - 8;
		if(zero)animate(AyaBack.get(0));
		else{
			animate(AyaBack.get(1));
		}
		zero = !zero;
	}

	public void moveDown() {
		y = y + 8;
		if(zero)animate(AyaForward.get(0));
		else{
			animate(AyaForward.get(1));
		}
		zero = !zero;
	}

	public void moveRight() {
		x = x + 8;
		
		if(zero)animate(AyaRight.get(0));
		else{
			animate(AyaRight.get(1));
		}
		zero = !zero;
	}

	public void moveLeft() {
		x = x - 8;
		if(zero)animate(AyaLeft.get(0));
		else{
			animate(AyaLeft.get(1));
		}
		zero = !zero;
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
		if(y >= StoryScreen.height- height){
			setY(StoryScreen.height - height);
		}
		if(x <= 0){
			setX(0);
		}
		if(x >= StoryScreen.width - width){
			setX(StoryScreen.width - width);
		}
	}
	
	public void radio() {
		//Radio.radioCall();
	}
	
	public BufferedImage getImage(){
		return sprite;
	}
}
