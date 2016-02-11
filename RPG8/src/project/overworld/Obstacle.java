package project.overworld;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Obstacle {
	public String name;
	public int xPos;
	public int yPos;
	public int sizeX;
	public int sizeY;
	Image image;
	public Obstacle(String name, int xPos, int yPos, int sizeX, int sizeY,Image image) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.image = image;
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
	public void drawImage(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image,xPos,yPos,null);
		
	}
	

}
