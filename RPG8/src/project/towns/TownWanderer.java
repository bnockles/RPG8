package project.towns;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 
 * @author Jingwen Li 2-23
 *
 */
public class TownWanderer {
	
	int x;
	int y;
	String name;
	BufferedImage sprite;
	public TownWanderer(int x, int y, String name, String imageLocation){
		this.name = name;
		int width = 200;
		int height = 200;
		this.x = x;
		this.y = y;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		try {
			BufferedImage original = ImageIO.read(url);
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getImage(){
		return sprite;
	}

	public void moveUp() {
		y = y - 10;
	}

	public void moveDown() {
		y = y +10;
	}

	public void moveLeft() {
		x-=10;
	}

	public void moveRight() {
		x+=10;
	}
	
}
