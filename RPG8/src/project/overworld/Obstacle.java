package project.overworld;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Obstacle {
	public String name;
	public int xPos;
	public int yPos;
	public int sizeX;
	public int sizeY;
	String image;
	BufferedImage object;

	public Obstacle(String name, int xPos, int yPos, int sizeX, int sizeY, String image) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.image = image;
		try {
			URL url = getClass().getResource(image);
			this.object = ImageIO.read(url);

		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public BufferedImage getImage() {
		return object;
	}

	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, sizeX, sizeY);
	}

}
