package project.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * Muhammad
 */

public class NPC {

	BufferedImage sprite;
	public String name;
	public int x;
	public int y;
	int width = 30;
	int height = 46;
	public static int weapon = 10;
	public int strength = 100;
	String[] array;
	
	public NPC(int x, int y, String picLocation, String[] array) {
		this.x = x;
		this.y = y;
		this.array = array;
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
	
	public BufferedImage getImage(){
		return sprite;
	}
	
	public void randomX() {
		x += 75; //random.nextInt((500 - 10 + 1) + 10);
	}
	public void randomY() {
		Random random = new Random();
		y += 75; //(random.nextInt(500 - 10 + 1) + 10);
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public String[] getArray() {
		return array;
	}
	
}

