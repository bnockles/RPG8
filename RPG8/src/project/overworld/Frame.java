package project.overworld;

import java.awt.Rectangle;

public abstract class Frame {
	 int xPos;
	 int yPos;
	 int sizeX;
	 int sizeY;
	public Frame(int xPos, int yPos, int sizeX, int sizeY) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
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
}
