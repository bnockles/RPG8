package project.overworld;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class Obstacle {
	public String name;
	public int xPos;
	public int yPos;
	public int sizeX;
	public int sizeY;
	String image;
	BufferedImage sprite;
	public Obstacle(String name, int xPos, int yPos, int sizeX, int sizeY,String image) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.image = image;
		sprite = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
		// "/images/cats/long cat.jpg"
		URL url = getClass().getResource(image);
		try {
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			// what to draw, where to start (x,y),
			// width of canvas (relative to start),
			// height of canvas (relative to start),
			// where to start from original (x,y)
			// width of original, height
			// null
			g.drawImage(original, xPos, yPos, sizeX, sizeY, 0, 0, w, h, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getImage(){
		return sprite;
	}
	public String getName() {
		return name;
	}


	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
	
	

}
