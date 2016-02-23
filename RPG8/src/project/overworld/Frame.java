package project.overworld;

import java.awt.Rectangle;

public abstract class Frame {
	 int xPos;
	 int yPos;
	 int sizeX;
	 int sizeY;
	 int region;
	public Frame(int xPos, int yPos, int sizeX, int sizeY, int region) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.region = region;
	}
	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, sizeX, sizeY);
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
	public int getRegion(){
		return region;
	}
}
